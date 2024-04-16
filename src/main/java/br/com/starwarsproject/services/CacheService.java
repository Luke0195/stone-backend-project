package br.com.starwarsproject.services;

public interface CacheService {
    void evictAllCacheValues(String cacheName);
}
