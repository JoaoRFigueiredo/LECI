package tqs.airquality.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import tqs.airquality.app.cache.Cache;
import tqs.airquality.app.models.AirQuality;
import tqs.airquality.app.service.AirQualityService;
import tqs.airquality.app.service.GeocodingService;
import tqs.airquality.app.utils.Location;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class AirQualityController {

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
    private static final String LOCATION = "location";
    private static final String HOMEPAGE = "homepage-air-quality";
    private static final String ADDRESS404 = "address404";
    private static final String ADDRNOTFOUND = "Address not found!";

    private static final Logger LOGGER = Logger.getLogger( AirQualityRestController.class.getName() );

    @GetMapping("/")
    public String home(){
        return HOMEPAGE;
    }

    @GetMapping("/cache")
    public String cache(Model model){

        LOGGER.log(Level.INFO,"New GET /cache request.");

        model.addAttribute("currentDayCache", currentDayCache);
        model.addAttribute("historicalCache", historicalCache);
        model.addAttribute("forecastCache", forecastCache);
        return "cache-information";
    }

    @GetMapping("/search")
    public RedirectView redirectWithUsingRedirectView(
            RedirectAttributes attributes,
            String address,
            String scope,
            String startDate,
            String endDate
    ) {
        if (address.equals("") || scope.equals(""))
            return new RedirectView("");
        attributes.addAttribute("address", address);
        switch (scope) {
            case "forecast":
                LOGGER.log(Level.INFO,"New GET /search request redirected to /forecast.");
                return new RedirectView("forecast");
            case "historical":
                if (startDate.equals("") || endDate.equals("")) {
                    LOGGER.log(Level.WARNING,"New GET /search request redirected to / because invalid dates.");
                    return new RedirectView("");
                }
                LOGGER.log(Level.INFO,"New GET /search request redirected to /historical.");
                attributes.addAttribute("startDate", startDate);
                attributes.addAttribute("endDate", endDate);
                return new RedirectView("historical");
            default:
                LOGGER.log(Level.INFO,"New GET /search request redirected to /today.");
                return new RedirectView("today");
        }
    }


    @GetMapping(value = "/today")
    public String getAirQualityOfTodayFromCoordinates(RedirectAttributes attributes, String address, Model model) {

        LOGGER.log(Level.INFO,"New GET /today request.");

        var airQuality = currentDayCache.getRequestFromCache(address.hashCode());
        Location location;

        if (airQuality == null){
            location = geocodingService.getCoordinatesFromAddress(address);
            if (location == null) {
                model.addAttribute(ADDRESS404, ADDRNOTFOUND);
                return HOMEPAGE;
            }
            airQuality = airQualityService.getCurrentAirQuality(location);
        } else {
            location = airQuality.getLocation();
        }

        currentDayCache.saveRequestToCache(address.hashCode(),airQuality);

        model.addAttribute(LOCATION, location);
        model.addAttribute("airQuality", airQuality);

        return "current-air-quality";
    }

    @GetMapping(value = "/forecast")
    public String getAirQualityForecastFromCoordinates( String address, Model model) {

        LOGGER.log(Level.INFO,"New GET /forecast request.");

        List<AirQuality> airQualities = forecastCache.getRequestFromCache(address.hashCode());
        Location location;

        if (airQualities == null){
            location = geocodingService.getCoordinatesFromAddress(address);
            if (location == null) {
                model.addAttribute(ADDRESS404, ADDRNOTFOUND);
                return HOMEPAGE;
            }
            airQualities = airQualityService.getForecastAirQuality(location);
        } else {
            location = airQualities.get(0).getLocation();
        }

        forecastCache.saveRequestToCache(address.hashCode(),airQualities);

        model.addAttribute(LOCATION, location);
        model.addAttribute("airQualities", airQualities);

        return "forecast-air-quality";
    }

    @GetMapping(value = "/historical")
    public String getAirQualityHistoricalFromCoordinatesAndStartDateAndEndDate(
            String address,
            String startDate,
            String endDate,
            Model model) {

        LOGGER.log(Level.INFO,"New GET /historical request.");

        String identifier = address+startDate+endDate;

        List<AirQuality> airQualities = historicalCache.getRequestFromCache(identifier.hashCode());
        Location location;

        if (airQualities == null){
            location = geocodingService.getCoordinatesFromAddress(address);
            if (location == null) {
                model.addAttribute(ADDRESS404, ADDRNOTFOUND);
                return HOMEPAGE;
            }
            airQualities = airQualityService.getHistoricalAirQuality(location,startDate,endDate);
        } else {
            location = airQualities.get(0).getLocation();
        }

        historicalCache.saveRequestToCache(identifier.hashCode(),airQualities);

        model.addAttribute(LOCATION, location);
        model.addAttribute("airQualities", airQualities);

        return "historical-air-quality";
    }
}
