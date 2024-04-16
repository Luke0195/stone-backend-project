package br.com.starwarsproject.services;

import br.com.starwarsproject.dtos.ClientDto;

public interface UserService {

    ClientDto createUser(ClientDto dto);
}
