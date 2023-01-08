package com.example.crypto_exchange.service;

import com.example.crypto_exchange.entity.UserCredential;

public interface UserCredentialService {

    UserCredential findUserCredentialByEmail(String email);
    UserCredential findUserCredentialByPhoneNumber(String phoneNumber);
}
