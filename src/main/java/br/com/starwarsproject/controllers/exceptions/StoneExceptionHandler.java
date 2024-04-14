package br.com.starwarsproject.controllers.exceptions;

import br.com.starwarsproject.mappers.StandardErrorMapper;
import br.com.starwarsproject.services.exceptions.EntityAlreadyExistsException;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StoneExceptionHandler {

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<StandardError> entityAlreadyExists(HttpServletRequest request, EntityAlreadyExistsException exception){
        int badRequest = HttpStatus.BAD_REQUEST.value();
        String pathUrl = request.getRequestURI();
        StandardError responseError = StandardErrorMapper
                .makeStandardErrorWithNoFields(badRequest, "Entity already exists!", pathUrl, exception.getMessage());
        return ResponseEntity.status(badRequest).body(responseError);
    }
}
