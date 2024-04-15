package br.com.starwarsproject.controllers;


import br.com.starwarsproject.dtos.BuyDto;
import br.com.starwarsproject.services.impl.BuyServiceImpl;
import br.com.starwarsproject.utils.HttpUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/buy")
@AllArgsConstructor
public class BuyController {

    private final BuyServiceImpl service;

    @PostMapping
    public ResponseEntity<BuyDto> checkIn(@Valid @RequestBody BuyDto dto){
      BuyDto response = service.create(dto);
      URI uri = HttpUtil.makeURIRequest(response.getId());
      return ResponseEntity.created(uri).body(response);
    }
}
