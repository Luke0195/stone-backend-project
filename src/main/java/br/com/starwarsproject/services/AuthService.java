package br.com.starwarsproject.services;


import br.com.starwarsproject.dtos.AuthDto;

public interface AuthService {

     String generateToken(AuthDto dto);
     String validateToken(String token);
}
