package br.com.starwarsproject.controllers;

import br.com.starwarsproject.domain.Client;
import br.com.starwarsproject.dtos.AuthDto;
import br.com.starwarsproject.dtos.TokenDto;
import br.com.starwarsproject.repositories.ClientRepository;
import br.com.starwarsproject.services.exceptions.EntityNotExistsException;
import br.com.starwarsproject.services.impl.AuthServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthServiceImpl authService;
    private final AuthenticationManager authenticationManager;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;


    @PostMapping
    public ResponseEntity<TokenDto> auth(@Valid @RequestBody AuthDto dto) {
        Client client = clientRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new EntityNotExistsException("User not found!"));
        if(passwordEncoder.matches(dto.getPassword(), client.getPassword())){
            String token = authService.generateToken(dto);
            TokenDto responseDto = TokenDto.builder().token(token).build();
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        }
        return ResponseEntity.badRequest().build();
    }

}
