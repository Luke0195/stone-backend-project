package br.com.starwarsproject.services.impl;

import br.com.starwarsproject.dtos.AuthDto;
import br.com.starwarsproject.services.AuthService;
import br.com.starwarsproject.services.exceptions.TokenGenerationException;
import br.com.starwarsproject.services.exceptions.TokenVerificationException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AuthServiceImpl implements AuthService {

    @Value("${api.token.secret}")
    private String tokenSecret;

    @Override
    public String generateToken(AuthDto user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            // with-issuer diz que está emitando o token.
            // with-subject - quem está ganhando esse token
            return JWT.create()
                    .withIssuer("stoneapp")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationData())
                    .sign(algorithm);

        }catch (JWTCreationException e ){
            e.printStackTrace();
            throw new TokenGenerationException(" Error while authentication");
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            return JWT.require(algorithm).withIssuer("stoneapp").build().verify(token).getSubject();
        }catch (JWTVerificationException e){
            return null;
        }
    }

    private Instant generateExpirationData(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03"));
    }
}
