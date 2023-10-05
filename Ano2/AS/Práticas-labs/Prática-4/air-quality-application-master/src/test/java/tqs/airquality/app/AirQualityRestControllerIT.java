package tqs.airquality.app;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import tqs.airquality.app.utils.CacheType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

// Rest Controller Tests using "REST Assured"

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AirQualityRestControllerIT {

    @LocalServerPort
    int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Test
    void whenValidAddressForCurrentAq_thenCode200AndReturnAq() {
        String address = "Murtosa";

        RestAssured.when().
                get("/api/today?address={address}", address).
                then().
                statusCode(200)
                .body(
                        "location.city", equalTo("Murtosa"),
                        "location.region", equalTo("Aveiro"),
                        "location.latitude", equalTo(40.75117f),
                        "location.longitude", equalTo(-8.644131f),
                        "size()", is(11)
                );
    }

    @Test
    void whenValidAddressForForecastAq_thenCode200AndReturnAqListWith6Elements() {
        String address = "Murtosa";

        RestAssured.when().
                get("/api/forecast?address={address}", address).
                then().
                statusCode(200)
                .body(
                        "[0].location.city", equalTo("Murtosa"),
                        "[0].location.region", equalTo("Aveiro"),
                        "[0].location.latitude", equalTo(40.75117f),
                        "[0].location.longitude", equalTo(-8.644131f),
                        "[0].size()", is(11),
                        "size()", greaterThanOrEqualTo(5)
                );
    }

    @Test
    void whenValidAddressAndStartDateAndEndDateForHistoricalAq_thenCode200AndReturnAqListWith8Elements() {

        String address = "Murtosa";
        String startDate = "01/04/2021";
        String endDate = "08/04/2021";

        RestAssured.when().
                get("/api/historical?address={address}&startDate={startDate}&endDate={endDate}", address, startDate, endDate).
                then().
                statusCode(200)
                .body(
                        "[0].location.city", equalTo("Murtosa"),
                        "[0].location.region", equalTo("Aveiro"),
                        "[0].location.latitude", equalTo(40.75117f),
                        "[0].location.longitude", equalTo(-8.644131f),
                        "[0].size()", is(11),
                        "size()", is(8)
                );
    }

    @Test
    void whenInvalidAddressForCurrentAq_thenCode404AndReturnNotFoundMessage() {
        String address = "tqstqstqstqs";

        RestAssured.when().
                get("/api/today?address={address}", address).
                then().
                statusCode(404)
                .body(
                        "code", equalTo(404),
                        "message", equalTo("Address not found.")
                );
    }

    @Test
    void whenInvalidAddressForHistoricalAq_thenCode404AndReturnNotFoundMessage() {
        String address = "tqstqstqstqs";
        String startDate = "01/04/2021";
        String endDate = "08/04/2021";

        RestAssured.when().
                get("/api/historical?address={address}&startDate={startDate}&endDate={endDate}", address, startDate, endDate).
                then().
                statusCode(404)
                .body(
                        "code", equalTo(404),
                        "message", equalTo("Address not found.")
                );
    }

    @Test
    void whenInvalidAddressForForecastAq_thenCode404AndReturnNotFoundMessage() {
        String address = "tqstqstqstqs";

        RestAssured.when().
                get("/api/forecast?address={address}", address).
                then().
                statusCode(404)
                .body(
                        "code", equalTo(404),
                        "message", equalTo("Address not found.")
                );
    }

    @Test
    void whenGetCache_thenReturnCode200AndCache() {
        RestAssured.when().
                get("/api/cache").
                then().
                statusCode(200)
                .body(
                        "size()", equalTo(3),
                        "[0].cacheType", equalTo(CacheType.CURRENT_DAY.toString()),
                        "[1].cacheType", equalTo(CacheType.FORECAST.toString()),
                        "[2].cacheType", equalTo(CacheType.HISTORICAL.toString())
                );
    }
}
