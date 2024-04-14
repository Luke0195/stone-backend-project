package br.com.starwarsproject.controllers;

import br.com.starwarsproject.dtos.ProductDto;
import br.com.starwarsproject.services.impl.ProductServiceImpl;
import br.com.starwarsproject.utils.HttpUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductServiceImpl productServiceImpl;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productRequestDto){
        ProductDto responseDto = productServiceImpl.create(productRequestDto);
        URI uri = HttpUtil.makeURIRequest(responseDto.getId());
        return ResponseEntity.created(uri).body(responseDto);
    }

}
