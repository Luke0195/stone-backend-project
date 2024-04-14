package br.com.starwarsproject.services;

import br.com.starwarsproject.dtos.ProductDto;

public interface ProductService {
    ProductDto create(ProductDto productRequestDto);
}
