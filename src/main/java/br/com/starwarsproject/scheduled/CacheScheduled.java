package br.com.starwarsproject.scheduled;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@Log4j2
public class CacheScheduled {

    @Scheduled(fixedDelay =  8, timeUnit = TimeUnit.HOURS)
    @CacheEvict("historic")
    public void clearHistoricCache(){
        log.info("Executou: "+ LocalDateTime.now());
    }


}
