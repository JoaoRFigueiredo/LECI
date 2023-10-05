package tqs.airquality.app.UnitTests.Cache;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import tqs.airquality.app.cache.Cache;
import tqs.airquality.app.models.AirQuality;
import tqs.airquality.app.utils.CacheType;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

class AirQualityCacheTest {

    private static final Logger LOGGER = Logger.getLogger( AirQualityCacheTest.class.getName() );

    // Instance to test
    private Cache<AirQuality> currentDayCache;

    // Fixed parameters
    private final CountDownLatch waiter = new CountDownLatch(1);
    private static final String address = "testLocation";
    private static final AirQuality aq = Mockito.mock(AirQuality.class);

    @BeforeEach
    void init() {
        currentDayCache = new Cache<>(1, CacheType.CURRENT_DAY);
        assertEquals(currentDayCache.getHits(),0);
        assertEquals(currentDayCache.getMisses(),0);
        assertEquals(currentDayCache.getRequests(),0);
    }

    @Test
    void whenRequestExistsAndNotExpired_thenReturnRequestAndIncreaseHitsAndRequests() {
        currentDayCache.saveRequestToCache(address.hashCode(), aq);
        AirQuality aq_result = currentDayCache.getRequestFromCache(address.hashCode());
        assertEquals(1, currentDayCache.getHits());
        assertEquals(0, currentDayCache.getMisses());
        assertEquals(1, currentDayCache.getRequests());
        assertEquals(aq_result,aq);
    }

    @Test
    void whenRequestExistsAndExpired_thenReturnRequestAndIncreaseMissesAndRequests() throws InterruptedException {
        currentDayCache.saveRequestToCache(address.hashCode(), aq);
        waiter.await(2, TimeUnit.SECONDS);
        AirQuality aq_result = currentDayCache.getRequestFromCache(address.hashCode());
        assertEquals(0, currentDayCache.getHits());
        assertEquals(1, currentDayCache.getMisses());
        assertEquals(1, currentDayCache.getRequests());
        assertNull(aq_result);
    }

    @Test
    void whenRequestNotExists_thenReturnNullAndIncreaseMissesAndRequests() {
        AirQuality aq_result = currentDayCache.getRequestFromCache(address.hashCode());
        assertEquals(0, currentDayCache.getHits());
        assertEquals(1, currentDayCache.getMisses());
        assertEquals(1, currentDayCache.getRequests());
        assertNull(aq_result);
    }
}
