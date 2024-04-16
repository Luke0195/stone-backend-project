package br.com.starwarsproject.controllers;


import br.com.starwarsproject.dtos.HistoricDto;
import br.com.starwarsproject.services.CacheService;
import br.com.starwarsproject.services.impl.BuyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/cache")
public class CacheController {
    @Autowired
    private BuyServiceImpl buyServiceImpl;

    @Autowired
    private CacheService cacheService;

    @PostMapping
    public void clear(@RequestParam("cacheName") String cacheName){
        cacheService.evictAllCacheValues(cacheName);
    }

    @CachePut("historics")
    public List<HistoricDto> updateCacheBuy(){
        return buyServiceImpl.findAllHistoricsWithCache();
    }

}
