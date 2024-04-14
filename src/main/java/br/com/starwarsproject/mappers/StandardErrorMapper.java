package br.com.starwarsproject.mappers;

import br.com.starwarsproject.controllers.exceptions.FieldError;
import br.com.starwarsproject.controllers.exceptions.StandardError;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class StandardErrorMapper {

    private StandardErrorMapper(){

    }

    public static StandardError makeStandardErrorWithNoFields(Integer status, String error, String path,
                                                              String exceptionMessage){
        return StandardError.builder()
                .timestamp(Instant.now())
                .status(status)
                .error(error)
                .path(path)
                .message(exceptionMessage)
                .errors(new HashSet<>())
                .build();
    }

    public static StandardError makeStandardErrorWithFields(Integer status, String error, String path,
                                                              String exceptionMessage, Set<FieldError> errors){
        return StandardError.builder()
                .timestamp(Instant.now())
                .status(status)
                .error(error)
                .path(path)
                .message(exceptionMessage)
                .errors(errors)
                .build();
    }
}
