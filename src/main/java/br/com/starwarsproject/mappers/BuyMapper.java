package br.com.starwarsproject.mappers;

import br.com.starwarsproject.domain.Buy;
import br.com.starwarsproject.dtos.BuyDto;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper
public interface BuyMapper {
    BuyMapper INSTANCE = Mappers.getMapper(BuyMapper.class);


    BuyDto mapEntityToDto(Buy entity);


    Buy mapDtoToEntity(BuyDto dto);
}
