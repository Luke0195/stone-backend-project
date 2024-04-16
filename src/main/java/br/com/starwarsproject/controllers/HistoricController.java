package br.com.starwarsproject.controllers;

import br.com.starwarsproject.dtos.HistoricDto;
import br.com.starwarsproject.services.impl.BuyServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/history")
@AllArgsConstructor
public class HistoricController {

    private final BuyServiceImpl service;
 // ira armazenar num hash map com concorrência.
    @GetMapping
    public ResponseEntity<List<HistoricDto>> findAll(){
        List<HistoricDto> response = service.findAllHistorics();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<List<HistoricDto>> findHistoricsByClientId(@PathVariable String id){
        List<HistoricDto> response = service.findAllHistoricsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
