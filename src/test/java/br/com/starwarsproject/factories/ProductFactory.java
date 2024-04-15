package br.com.starwarsproject.factories;


import br.com.starwarsproject.domain.Product;
import br.com.starwarsproject.dtos.ProductDto;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductFactory {

    private ProductFactory(){};

    public static Product makeProduct(){
        return Product.builder()
                .id(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(39.0))
                .title("any_title")
                .seller("Lucas Santos")
                .zipcode("3910194-010")
                .date("14/04/2024")
                .thumbnailHd("any_thumbnail")
                .build();
    };

    public static ProductDto makeProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .price(product.getPrice())
                .title(product.getTitle())
                .seller(product.getSeller())
                .zipcode(product.getZipcode())
                .date(product.getDate())
                .thumbnailHd(product.getThumbnailHd())
                .build();

    }
}
