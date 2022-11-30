package com.example.crypto_exchange.service;

public interface VerificationService {

    void sendVerificationSmsCode(String phoneNumber);

    void verifyRegistrationBySms(String phoneNumber, String code);
}
