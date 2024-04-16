package br.com.starwarsproject.controllers;

import br.com.starwarsproject.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @PostMapping
    public void clear(@RequestParam("cacheName") String cacheName){
        System.out.println(cacheName);
        cacheService.evictAllCacheValues(cacheName);
    }
}
