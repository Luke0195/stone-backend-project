package br.com.starwarsproject.controllers;

import br.com.starwarsproject.dtos.ProductDto;
import br.com.starwarsproject.repositories.ProductRepository;
import br.com.starwarsproject.services.impl.ProductServiceImpl;
import br.com.starwarsproject.utils.HttpUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.hibernate.query.SortDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping
public class ProductController {
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productRequestDto){
        ProductDto responseDto = productServiceImpl.create(productRequestDto);
        URI uri = HttpUtil.makeURIRequest(responseDto.getId());
        return ResponseEntity.created(uri).body(responseDto);
    }


    @GetMapping("/products")
    public ResponseEntity<Page<ProductDto>> findAllPaged(
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "title") String orderBy,
            @RequestParam(value ="direction", defaultValue = "DESC") String direction
    ){
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<ProductDto> products = productServiceImpl.findAllPaged(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

}
