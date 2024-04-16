package br.com.starwarsproject.mappers;

import br.com.starwarsproject.domain.Client;
import br.com.starwarsproject.dtos.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    Client mapClientDtoToEntity(ClientDto userDto);

    ClientDto mapClientEntityToDto(Client client);
}
