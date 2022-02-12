package de.tekay.npc_compendium.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFound(RuntimeException runtimeException, WebRequest webRequest) {
        return handleExceptionInternal(
                runtimeException,
                "ID COULD NOT BE FOUND!",
                new HttpHeaders(), HttpStatus.NOT_FOUND,
                webRequest
        );
    }
}
