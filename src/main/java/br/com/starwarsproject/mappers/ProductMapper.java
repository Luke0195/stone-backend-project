package br.com.starwarsproject.mappers;

import br.com.starwarsproject.domain.Product;
import br.com.starwarsproject.dtos.ProductDto;

public class ProductMapper {

    private ProductMapper(){}

    public static Product mapProductDtoToEntity(ProductDto productDto){
        return Product.builder().id(null)
                .title(productDto.getTitle())
                .price(productDto.getPrice())
                .zipcode(productDto.getZipcode())
                .seller(productDto.getSeller())
                .thumbnailHd(productDto.getThumbnailHd())
                .date(productDto.getDate())
                .build();
    }

    public static ProductDto mapProductEntityToDto(Product entity){
        return ProductDto.builder().id(entity.getId())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .zipcode(entity.getZipcode())
                .seller(entity.getSeller())
                .thumbnailHd(entity.getThumbnailHd())
                .date(entity.getDate())
                .build();
    }

}
