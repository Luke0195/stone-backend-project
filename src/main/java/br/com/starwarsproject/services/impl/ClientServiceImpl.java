package br.com.starwarsproject.services.impl;

import br.com.starwarsproject.domain.Client;
import br.com.starwarsproject.dtos.ClientDto;
import br.com.starwarsproject.mappers.ClientMapper;
import br.com.starwarsproject.repositories.ClientRepository;
import br.com.starwarsproject.services.UserService;
import br.com.starwarsproject.services.exceptions.EntityAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public ClientDto createUser(ClientDto dto) {
        Optional<Client> clientAlreadyExists = clientRepository.findByEmail(dto.getEmail());
        if(clientAlreadyExists.isPresent()) throw new EntityAlreadyExistsException("This e-mail is already taken!");
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        Client client = ClientMapper.INSTANCE.mapClientDtoToEntity(dto);
        client.setPassword(hashedPassword);
        clientRepository.save(client);
        return ClientMapper.INSTANCE.mapClientEntityToDto(client);

    }
}
