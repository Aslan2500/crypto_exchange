package com.example.crypto_exchange.exception.handler;

import com.example.crypto_exchange.exception.JwtAuthenticationException;
import com.example.crypto_exchange.exception.PhoneFormatException;
import com.example.crypto_exchange.exception.ResourceNotFoundException;
import com.example.crypto_exchange.exception.SecurityAnswerException;
import com.example.crypto_exchange.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String userNotFoundException(UserNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String jwtAuthenticationException(JwtAuthenticationException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String phoneFormatException(PhoneFormatException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resourceNotFoundException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String securityAnswerException(SecurityAnswerException ex) {
        return ex.getMessage();
    }
}
