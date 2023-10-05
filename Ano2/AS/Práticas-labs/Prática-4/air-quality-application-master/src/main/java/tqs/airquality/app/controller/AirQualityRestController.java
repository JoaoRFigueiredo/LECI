package tqs.airquality.app.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tqs.airquality.app.cache.Cache;
import tqs.airquality.app.models.AirQuality;
import tqs.airquality.app.service.AirQualityService;
import tqs.airquality.app.service.GeocodingService;
import tqs.airquality.app.utils.Location;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Tag(name = "Air Quality", description = "the Air Quality API")
@RestController
@RequestMapping("/api")
public class AirQualityRestController {

    @Autowired
    private AirQualityService airQualityService;

    @Autowired
    private GeocodingService geocodingService;

    @Autowired
    private Cache<AirQuality> currentDayCache;

    @Autowired
    private Cache<List<AirQuality>> historicalCache;

    @Autowired
    private Cache<List<AirQuality>> forecastCache;

    // Constants
    private static final String ADDRESS_NOT_FOUND = "{\"code\" : 404, \"message\" : \"Address not found.\"}";
    private static final Logger LOGGER = Logger.getLogger( AirQualityRestController.class.getName() );

    @Operation(summary = "Show cache statistics.")
    @GetMapping(value="/cache", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> cache() {

        LOGGER.log(Level.INFO,"New GET /cache request.");

        return new ResponseEntity<>(
                Stream.of(
                        currentDayCache,
                        forecastCache,
                        historicalCache)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Operation(summary = "Show current day air quality based on given address.")
    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAirQualityOfTodayFromCoordinates(String address) {

        LOGGER.log(Level.INFO,"New GET /today request.");

        var airQuality = currentDayCache.getRequestFromCache(address.hashCode());
        Location location;

        if (airQuality == null){
            location = geocodingService.getCoordinatesFromAddress(address);
            if (location == null) {
                return new ResponseEntity<>(ADDRESS_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
            airQuality = airQualityService.getCurrentAirQuality(location);
        }

        currentDayCache.saveRequestToCache(address.hashCode(),airQuality);

        return new ResponseEntity<>(airQuality, HttpStatus.OK);
    }

    @Operation(summary = "Show 5 day forecast air quality based on given address.")
    @GetMapping(value = "/forecast", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAirQualityForecastFromCoordinates( String address) {

        LOGGER.log(Level.INFO,"New GET /forecast request.");

        List<AirQuality> airQualities = forecastCache.getRequestFromCache(address.hashCode());
        Location location;

        if (airQualities == null){
            location = geocodingService.getCoordinatesFromAddress(address);
            if (location == null) {
                return new ResponseEntity<>(ADDRESS_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
            airQualities = airQualityService.getForecastAirQuality(location);
        }

        forecastCache.saveRequestToCache(address.hashCode(),airQualities);

        return new ResponseEntity<>(airQualities, HttpStatus.OK);
    }

    @Operation(summary = "Show historical air quality based on given address, start date and end date.")
    @GetMapping(value = "/historical", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAirQualityHistoricalFromCoordinatesAndStartDateAndEndDate(
            String address,
            @Parameter(description = "Date in format dd/MM/yyyy", required = true) String startDate,
            @Parameter(description = "Date in format dd/MM/yyyy", required = true) String endDate) {

        LOGGER.log(Level.INFO,"New GET /historical request.");

        String identifier = address+startDate+endDate;

        List<AirQuality> airQualities = historicalCache.getRequestFromCache(identifier.hashCode());
        Location location;

        if (airQualities == null){
            location = geocodingService.getCoordinatesFromAddress(address);
            if (location == null) {
                return new ResponseEntity<>(ADDRESS_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
            airQualities = airQualityService.getHistoricalAirQuality(location,startDate,endDate);
        }

        historicalCache.saveRequestToCache(identifier.hashCode(),airQualities);

        return new ResponseEntity<>(airQualities, HttpStatus.OK);
    }
}
