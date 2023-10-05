package tqs.airquality.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;
import tqs.airquality.app.models.AirQuality;
import tqs.airquality.app.utils.Location;

import java.net.URI;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.String.format;

@Service
public class AirQualityService {

    @Value("${api.openweather.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;


    private ObjectMapper objectMapper = new ObjectMapper();

    private static final String AIR_QUALITY_TODAY = "http://api.openweathermap.org/data/2.5/air_pollution?lat={coordLat}&lon={coordLon}&appid={apiKey}";
    private static final String AIR_QUALITY_HISTORICAL = "http://api.openweathermap.org/data/2.5/air_pollution/history?lat={coordLat}&lon={coordLon}&start={startDate}&end={endDate}&appid={apiKey}";
    private static final String AIR_QUALITY_FORECAST = "http://api.openweathermap.org/data/2.5/air_pollution/forecast?lat={coordLat}&lon={coordLon}&appid={apiKey}";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final String COMPONENTS = "components";
    private static final Logger LOGGER = Logger.getLogger( AirQualityService.class.getName() );

    // ERROR MESSAGES
    private static final String ERR_JSON = "Error parsing JSON";

    public AirQuality getCurrentAirQuality(Location location) {
        LOGGER.log(Level.INFO,"Getting current Air Quality for provided location...");
        URI url = new UriTemplate(AIR_QUALITY_TODAY).expand(location.getLatitude(),location.getLongitude(),apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return convertJsonToAirQuality(response, location);
    }

    public List<AirQuality> getHistoricalAirQuality(Location location, String startDateText, String endDateText) {
        LOGGER.log(Level.INFO,"Getting historical Air Quality for provided location and dates...");
        var startDate = convertStartDateToUnixTSString(startDateText);
        var endDate = convertEndDateToUnixTSString(endDateText);
        URI url = new UriTemplate(AIR_QUALITY_HISTORICAL).expand(location.getLatitude(),location.getLongitude(),startDate,endDate,apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return convertJsonToAirQualityList(response, location);
    }

    public List<AirQuality> getForecastAirQuality(Location location) {
        LOGGER.log(Level.INFO,"Getting forecast Air Quality for provided location...");
        URI url = new UriTemplate(AIR_QUALITY_FORECAST).expand(location.getLatitude(),location.getLongitude(),apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return convertJsonToAirQualityListForecast(response, location);
    }

    private AirQuality convertJsonToAirQuality(ResponseEntity<String> response, Location location) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            return new AirQuality(
                location,
                new Date(Long.parseLong(root.path("list").get(0).path("dt").asText() + "000")),
                root.path("list").get(0).path(COMPONENTS).path("co").asDouble(),
                root.path("list").get(0).path(COMPONENTS).path("no").asDouble(),
                root.path("list").get(0).path(COMPONENTS).path("no2").asDouble(),
                root.path("list").get(0).path(COMPONENTS).path("o3").asDouble(),
                root.path("list").get(0).path(COMPONENTS).path("so2").asDouble(),
                root.path("list").get(0).path(COMPONENTS).path("pm2_5").asDouble(),
                root.path("list").get(0).path(COMPONENTS).path("pm10").asDouble(),
                root.path("list").get(0).path(COMPONENTS).path("nh3").asDouble()
            );

        } catch (JsonProcessingException e) {
            LOGGER.severe(format("Error while parsing JSON from external AirQuality API for location %s}", location));
            throw new RuntimeException(ERR_JSON, e);
        }
    }

    private List<AirQuality> convertJsonToAirQualityList(ResponseEntity<String> response, Location location) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            List<AirQuality> historical = new ArrayList<>();
            Iterator<JsonNode> iterator = root.withArray("list").elements();
            Date lastDay = null;
            if (iterator.hasNext()) {
                lastDay = new Date(Long.parseLong(objectMapper.readTree(iterator.next().toString()).path("dt") + "000"));
                while (iterator.hasNext()) {
                    JsonNode n = iterator.next();
                    var day = new Date(Long.parseLong(objectMapper.readTree(n.toString()).path("dt") + "000"));
                    if (day.toString().compareTo(lastDay.toString()) != 0) {
                        lastDay = getDate(location, historical, n, day);
                    }
                }
            }

            return historical;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(ERR_JSON, e);
        }
    }

    private List<AirQuality> convertJsonToAirQualityListForecast(ResponseEntity<String> response, Location location) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            List<AirQuality> historical = new ArrayList<>();
            Iterator<JsonNode> iterator = root.withArray("list").elements();

            var c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);

            long unixTimeStamp = c.getTimeInMillis();
            var midnight = new Date(unixTimeStamp);
            Date lastDay = null;
            if (iterator.hasNext()) {
                lastDay = new Date(Long.parseLong(objectMapper.readTree(iterator.next().toString()).path("dt") + "000"));
                while (iterator.hasNext()) {
                    JsonNode n = iterator.next();
                    var day = new Date(Long.parseLong(objectMapper.readTree(n.toString()).path("dt") + "000"));
                    if (day.compareTo(midnight) > 0 && day.toString().compareTo(lastDay.toString()) != 0) {
                        lastDay = getDate(location, historical, n, day);
                    }
                }
            }

            return historical;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(ERR_JSON, e);
        }
    }

    private Date getDate(Location location, List<AirQuality> historical, JsonNode n, Date day) {
        Date lastDay;
        historical.add(
                new AirQuality(
                        location,
                        day,
                        n.path(COMPONENTS).path("co").asDouble(),
                        n.path(COMPONENTS).path("no").asDouble(),
                        n.path(COMPONENTS).path("no2").asDouble(),
                        n.path(COMPONENTS).path("o3").asDouble(),
                        n.path(COMPONENTS).path("so2").asDouble(),
                        n.path(COMPONENTS).path("pm2_5").asDouble(),
                        n.path(COMPONENTS).path("pm10").asDouble(),
                        n.path(COMPONENTS).path("nh3").asDouble()
                )
        );
        lastDay=day;
        return lastDay;
    }

    private String convertStartDateToUnixTSString(String dateText) {
        java.util.Date dateDT = null;
        try {
            dateDT = dateFormat.parse(dateText);
        } catch (ParseException e) {
            LOGGER.log(Level.WARNING,"Error parsing provided startDate to UNIX date format.");
        }
        assert dateDT != null;
        return String.valueOf((dateDT.getTime() - 86400000L) / 1000L);
    }

    private String convertEndDateToUnixTSString(String dateText) {
        java.util.Date dateDT = null;
        try {
            dateDT = dateFormat.parse(dateText);
        } catch (ParseException e) {
            LOGGER.log(Level.WARNING,"Error parsing provided endDate to UNIX date format.", e);
        }
        assert dateDT != null;
        return String.valueOf(dateDT.getTime() / 1000L);
    }
}
