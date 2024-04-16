package br.com.starwarsproject.services;

import br.com.starwarsproject.dtos.ClientDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    ClientDto createUser(ClientDto dto);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
