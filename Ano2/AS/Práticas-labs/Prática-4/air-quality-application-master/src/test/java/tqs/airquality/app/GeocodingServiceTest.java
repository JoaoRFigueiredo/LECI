package tqs.airquality.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;
import tqs.airquality.app.service.GeocodingService;
import tqs.airquality.app.utils.Location;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class GeocodingServiceTest {

    @Value("${api.positionstack.key}")
    private String apiKey;

    @InjectMocks
    private GeocodingService geocodingService;

    @Mock
    private RestTemplate restTemplate;

    private static final String GEOCODING = "http://api.positionstack.com/v1/forward?access_key={apiKey}&query={address}";

    @Test
    void whenStringAddress_thenReturnLocation() {

        // Input
        String address = "Murtosa";

        // Mock external API output
        URI url = new UriTemplate(GEOCODING).expand(apiKey, address);
        ResponseEntity<String> response = new ResponseEntity<String>("{\"data\":[{\"latitude\":40.751173,\"longitude\":-8.644131,\"type\":\"locality\",\"name\":\"Murtosa\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":1,\"region\":\"Aveiro\",\"region_code\":\"AV\",\"county\":null,\"locality\":\"Murtosa\",\"administrative_area\":\"Monte\",\"neighbourhood\":null,\"country\":\"Portugal\",\"country_code\":\"PRT\",\"continent\":\"Europe\",\"label\":\"Murtosa, AV, Portugal\"},{\"latitude\":40.738394,\"longitude\":-8.653465,\"type\":\"localadmin\",\"name\":\"Murtosa\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":1,\"region\":\"Aveiro\",\"region_code\":\"AV\",\"county\":null,\"locality\":null,\"administrative_area\":\"Murtosa\",\"neighbourhood\":null,\"country\":\"Portugal\",\"country_code\":\"PRT\",\"continent\":\"Europe\",\"label\":\"Murtosa, AV, Portugal\"}]}", HttpStatus.OK);
        Mockito.when(restTemplate.getForEntity(url, String.class)).thenReturn(response);

        // Call Service
        Location locMurtosa = geocodingService.getCoordinatesFromAddress(address);

        // Check output
        assertThat(locMurtosa.getCity()).isEqualTo("Murtosa");
        assertThat(locMurtosa.getRegion()).isEqualTo("Aveiro");
        assertThat(locMurtosa.getLatitude()).isEqualTo(40.751173f);
        assertThat(locMurtosa.getLongitude()).isEqualTo(-8.644131f);

    }

}
