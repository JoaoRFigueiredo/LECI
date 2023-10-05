package tqs.airquality.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AppApplication.class)
@AutoConfigureMockMvc

// Simple web page code check with MockMvc (content is already tested in REST Controller Tests)
class AirQualityControllerIT {

    @Autowired
    private MockMvc mvc;

    @Test
    void whenValidAddressForCurrentAq_thenCode200() throws Exception {

        String address = "Murtosa";

        mvc.perform(get("/api/today?address={address}",address)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void whenValidAddressForForecastAq_thenCode200() throws Exception {

        String address = "Murtosa";

        mvc.perform(get("/api/forecast?address={address}",address)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void whenValidAddressForHistoricalAq_thenCode200() throws Exception {

        String address = "Murtosa";
        String startDate = "01/04/2021";
        String endDate = "08/04/2021";

        mvc.perform(get("/api/historical?address={address}&startDate={startDate}&endDate={endDate}", address, startDate, endDate)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void whenInvalidAddressForCurrentAq_thenCode404() throws Exception {

        String address = "tqstqstqstqs";

        mvc.perform(get("/api/today?address={address}",address)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenInvalidAddressForForecastAq_thenCode404() throws Exception {

        String address = "tqstqstqstqs";

        mvc.perform(get("/api/forecast?address={address}",address)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenInvalidAddressForHistoricalAq_thenCode404() throws Exception {

        String address = "tqstqstqstqs";
        String startDate = "01/04/2021";
        String endDate = "08/04/2021";

        mvc.perform(get("/api/historical?address={address}&startDate={startDate}&endDate={endDate}", address, startDate, endDate)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenGetCache_thenReturnCode200() throws Exception {
        mvc.perform(get("/api/cache")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
