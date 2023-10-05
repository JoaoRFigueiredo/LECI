package tqs.airquality.app.cache;

import tqs.airquality.app.utils.CacheType;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.String.format;

public class Cache<T> {
    private long ttl;
    private int requests;
    private int misses;
    private int hits;
    private CacheType cacheType;

    private Map<Integer, T> cachedRequests;
    private Map<Integer, Long> cachedRequestsTtl;
    private static final Logger LOGGER = Logger.getLogger( Cache.class.getName() );

    public Cache(long ttl, CacheType cacheType) {
        this.cacheType=cacheType;
        this.ttl = ttl;
        this.requests = 0;
        this.misses = 0;
        this.hits = 0;
        this.cachedRequests = new HashMap<>();
        this.cachedRequestsTtl = new HashMap<>();
    }

    public void saveRequestToCache(int identifier, T obj) {
        LOGGER.log(Level.INFO, format("Saving identifier %d in %s Cache...",identifier, cacheType));
        this.cachedRequests.put(identifier, obj);
        this.cachedRequestsTtl.put(identifier, System.currentTimeMillis() + this.ttl * 1000);
    }

    public T getRequestFromCache(int identifier) {

        this.requests++;
        T cachedObj = null;
        if (!this.cachedRequestsTtl.containsKey(identifier)){
            LOGGER.log(Level.INFO, format("Identifier %d doesn't exist in %s Cache.", identifier, cacheType));
            this.misses++;
        } else if (System.currentTimeMillis() > this.cachedRequestsTtl.get(identifier)){
            LOGGER.log(Level.INFO, format("Identifier %d exists in %s Cache but has expired",identifier, cacheType));
            this.misses++;
            this.cachedRequestsTtl.remove(identifier);
            this.cachedRequests.remove(identifier);
        } else {
            this.hits++;
            LOGGER.log(Level.INFO, format("Identifier %d exists in %s Cache, returning cached object...",identifier, cacheType ));
            cachedObj = cachedRequests.get(identifier);

        }
        return cachedObj;
    }

    public int getRequests() {
        return requests;
    }

    public int getMisses() {
        return misses;
    }

    public int getHits() {
        return hits;
    }

    public CacheType getCacheType() { return cacheType; }
}
