package com.example.crypto_exchange.service;

import com.example.crypto_exchange.dto.RegisterUserDTO;

public interface UserService {

    void registerUser(RegisterUserDTO dto);

    void deleteUserById(Long id);
}
