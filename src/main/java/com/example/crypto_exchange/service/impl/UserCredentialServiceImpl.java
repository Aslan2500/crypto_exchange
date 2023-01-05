package com.example.crypto_exchange.service.impl;

import com.example.crypto_exchange.entity.UserCredential;
import com.example.crypto_exchange.exception.UserNotFoundException;
import com.example.crypto_exchange.repository.UserCredentialRepository;
import com.example.crypto_exchange.service.UserCredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserCredentialServiceImpl implements UserCredentialService {

    private final UserCredentialRepository repository;

    @Override
    public UserCredential findUserCredentialByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public UserCredential findUserCredentialByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
