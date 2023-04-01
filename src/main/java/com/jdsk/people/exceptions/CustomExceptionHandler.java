package com.jdsk.people.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdsk.people.utils.response.DefaultResponse;

import discord4j.rest.json.response.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<DefaultResponse<Object>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String message = "Data integrity violation: " + ex.getMessage();
        return DefaultResponse.onThrow400ResponseTypeInfo(message);
    }
}
    