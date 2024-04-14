package br.com.starwarsproject.services;

import br.com.starwarsproject.dtos.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductDto create(ProductDto productRequestDto);
    Page<ProductDto> findAllPaged(Pageable pageable);
}
