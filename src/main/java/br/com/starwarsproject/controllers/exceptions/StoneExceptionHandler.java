package br.com.starwarsproject.controllers.exceptions;

import br.com.starwarsproject.mappers.StandardErrorMapper;
import br.com.starwarsproject.services.exceptions.EntityAlreadyExistsException;

import br.com.starwarsproject.services.exceptions.TransformValueException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@ControllerAdvice
public class StoneExceptionHandler {

    private final View error;

    public StoneExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<StandardError> entityAlreadyExists(HttpServletRequest request, EntityAlreadyExistsException exception){
        int badRequest = getStatusCode(HttpStatus.BAD_REQUEST);
        String pathUrl = getRequestUri(request);
        StandardError responseError = StandardErrorMapper
                .makeStandardErrorWithNoFields(badRequest, "Entity already exists!", pathUrl, exception.getMessage());
        return ResponseEntity.status(badRequest).body(responseError);
    }

    @ExceptionHandler(TransformValueException.class)
    public ResponseEntity<StandardError> failToTransformValue(HttpServletRequest request, TransformValueException exception){
        int badRequest = getStatusCode(HttpStatus.BAD_REQUEST);
        String pathUrl = getRequestUri(request);
        StandardError responseError = StandardErrorMapper.makeStandardErrorWithNoFields(badRequest, "Fail to parse data",
                pathUrl, exception.getMessage());
        return ResponseEntity.status(badRequest).body(responseError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> hibernateValidation(HttpServletRequest request, MethodArgumentNotValidException  exception){
        int badRequest = getStatusCode(HttpStatus.BAD_REQUEST);
        String pathUrl = getRequestUri(request);
        Set<FieldError> errors = getValidationErrors(exception);
        StandardError responseError =  StandardErrorMapper.makeStandardErrorWithFields(badRequest,
                "Validation Exception", pathUrl, "Invalid Fields", errors);
        return ResponseEntity.status(badRequest).body(responseError);
    }


    private static int getStatusCode(HttpStatus httpStatus){
        return httpStatus.value();
    }

    private static String getRequestUri(HttpServletRequest request){
        return request.getRequestURI();
    }

    private static  Set<FieldError> getValidationErrors(MethodArgumentNotValidException exception){
        Set<FieldError> errors = new HashSet<>();
        exception.getFieldErrors().forEach(x -> {
            String fieldName = x.getField();
            String fieldDescription = x.getDefaultMessage();
            errors.add( FieldError.builder().fieldName(fieldName).message(fieldDescription).build());
        });
        return errors;
    }
}
