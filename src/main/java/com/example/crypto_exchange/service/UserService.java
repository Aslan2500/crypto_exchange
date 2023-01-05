package com.example.crypto_exchange.service;

import com.example.crypto_exchange.entity.User;
import com.example.crypto_exchange.entity.UserCredential;
import com.example.crypto_exchange.entity.dto.request.PasswordRecoveryDto;

public interface UserService {

    void registerUser(User user);

    void deleteUserById(Long id);

    void recoverPassword(PasswordRecoveryDto dto);

    User findById(Long id);

    User findByEmail(String email);

    UserCredential findUserCredentialByEmail(String email);
}
