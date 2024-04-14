package br.com.starwarsproject.services.exceptions;

public class EntityNotExistsException extends RuntimeException{

    public EntityNotExistsException(){}

    public EntityNotExistsException(String message){
        super(message);
    }
}
