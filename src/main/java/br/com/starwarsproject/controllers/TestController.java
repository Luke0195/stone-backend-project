package br.com.starwarsproject.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value ="/products")
    public ResponseEntity<String> getTest(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World");
    }
}
