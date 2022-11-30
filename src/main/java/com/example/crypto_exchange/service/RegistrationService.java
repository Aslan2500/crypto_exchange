package com.example.crypto_exchange.service;

import com.example.crypto_exchange.entity.dto.RegisterUserDto;

public interface RegistrationService {

    void registerUser(RegisterUserDto dto);
}
