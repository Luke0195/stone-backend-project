package br.com.starwarsproject.mappers;

import br.com.starwarsproject.domain.Client;
import br.com.starwarsproject.dtos.ClientDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T13:53:56-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Azul Systems, Inc.)"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client mapClientDtoToEntity(ClientDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.id( userDto.getId() );
        client.name( userDto.getName() );
        client.email( userDto.getEmail() );
        client.password( userDto.getPassword() );
        client.role( userDto.getRole() );

        return client.build();
    }

    @Override
    public ClientDto mapClientEntityToDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto.ClientDtoBuilder clientDto = ClientDto.builder();

        clientDto.id( client.getId() );
        clientDto.name( client.getName() );
        clientDto.email( client.getEmail() );
        clientDto.password( client.getPassword() );
        clientDto.role( client.getRole() );

        return clientDto.build();
    }
}
