package com.example.crypto_exchange.exception;

public class WrongCurrencyInputException extends RuntimeException {

    public WrongCurrencyInputException(String message) {
        super(message);
    }
}
