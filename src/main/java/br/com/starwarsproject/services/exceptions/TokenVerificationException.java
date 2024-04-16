package br.com.starwarsproject.services.exceptions;

public class TokenVerificationException extends  RuntimeException{

    public TokenVerificationException(){};

    public TokenVerificationException(String message){
        super(message);
    }
}
