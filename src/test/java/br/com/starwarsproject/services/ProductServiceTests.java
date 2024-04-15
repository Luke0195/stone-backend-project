package br.com.starwarsproject.services;

import br.com.starwarsproject.domain.Product;
import br.com.starwarsproject.dtos.ProductDto;
import br.com.starwarsproject.factories.ProductFactory;
import br.com.starwarsproject.repositories.ProductRepository;
import br.com.starwarsproject.services.exceptions.EntityAlreadyExistsException;
import br.com.starwarsproject.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductServiceImpl service;
    @Mock
    private ProductRepository repository;

    private Product product;

    private ProductDto existingProductDto;


    @BeforeEach
    void setup(){
        product = ProductFactory.makeProduct();
        existingProductDto = ProductFactory.makeProductDto(product);
        Mockito.when(repository.save(Mockito.any(Product.class))).thenReturn(product);
        Mockito.when(repository.findByTitle(existingProductDto.getTitle())).thenThrow(EntityAlreadyExistsException.class);
    }

    @DisplayName("create  should return a product when valid data is provided")
    @Test
    void createShouldCreateAnProductWhenValidDataIsProvided(){
        ProductDto response = service.create(ProductFactory.makeProductDto(product));
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getId());
        Assertions.assertNotNull(response.getTitle());
        repository.save(product);
    }


}

