package br.com.starwarsproject.services.impl;

import br.com.starwarsproject.domain.Product;
import br.com.starwarsproject.dtos.ProductDto;
import br.com.starwarsproject.mappers.ProductMapper;
import br.com.starwarsproject.repositories.ProductRepository;
import br.com.starwarsproject.services.ProductService;
import br.com.starwarsproject.services.exceptions.EntityAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    @Transactional
    public ProductDto create(ProductDto productRequestDto) {
       Optional<Product> findProductByTitle = repository.findByTitle(productRequestDto.getTitle());
       if(findProductByTitle.isPresent()) throw new EntityAlreadyExistsException("Product title already taken");
       Optional<Product> findProductByCode = repository.findByZipcode(productRequestDto.getZipcode());
       if(findProductByCode.isPresent()) throw new EntityAlreadyExistsException("ZipCode must be unique");
       Product createdProduct = ProductMapper.mapProductDtoToEntity(productRequestDto);
       createdProduct = repository.save(createdProduct);
       return ProductMapper.mapProductEntityToDto(createdProduct);
    }

    @Override
    public Page<ProductDto> findAllPaged(Pageable pageable) {
        return repository.findAll(pageable).map(ProductMapper::mapProductEntityToDto);
    }
}
