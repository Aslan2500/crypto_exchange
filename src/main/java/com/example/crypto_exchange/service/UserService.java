package com.example.crypto_exchange.service;

import com.example.crypto_exchange.entity.User;
import com.example.crypto_exchange.entity.UserCredential;

public interface UserService {

    void registerUser(User user);

    void deleteUserById(Long id);

    User findById(Long id);

    User findByEmail(String email);

    UserCredential findUserCredentialByEmail(String email);
}
