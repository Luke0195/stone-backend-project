package br.com.starwarsproject.services.exceptions;

public class TransformValueException extends  RuntimeException{

    public TransformValueException(){}

    public TransformValueException(String message){
        super(message);
    }

}
