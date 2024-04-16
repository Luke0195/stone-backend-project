package br.com.starwarsproject.controllers;

import br.com.starwarsproject.dtos.ClientDto;
import br.com.starwarsproject.services.impl.ClientServiceImpl;
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
@RequestMapping(value = "/clients")
@AllArgsConstructor
public class ClientController {

    private final ClientServiceImpl clientService;


    @PostMapping
    public ResponseEntity<ClientDto> create(@Valid @RequestBody ClientDto dto){
        ClientDto response = clientService.createUser(dto);
        URI uri = HttpUtil.makeURIRequest(response.getId());
        return ResponseEntity.created(uri).body(response);
     }
}
