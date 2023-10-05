package tqs.airquality.app.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import tqs.airquality.app.cache.Cache;
import tqs.airquality.app.models.AirQuality;
import tqs.airquality.app.utils.CacheType;

import java.util.List;

@Configuration
public class AirQualityConfig {

    private Cache<AirQuality> currentDayCache = new Cache<>(120, CacheType.CURRENT_DAY);
    private Cache<List<AirQuality>> historicalCache = new Cache<>(120, CacheType.HISTORICAL);
    private Cache<List<AirQuality>> forecastCache = new Cache<>(120, CacheType.FORECAST);

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    // Cache
    @Bean
    public Cache<AirQuality> currentDayCache() { return currentDayCache; }

    @Bean
    public Cache<List<AirQuality>> historicalCache() { return historicalCache; }

    @Bean
    public Cache<List<AirQuality>> forecastCache() { return forecastCache; }

}
