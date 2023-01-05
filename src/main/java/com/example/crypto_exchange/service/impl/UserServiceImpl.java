package com.example.crypto_exchange.service.impl;

import com.example.crypto_exchange.entity.User;
import com.example.crypto_exchange.entity.UserCredential;
import com.example.crypto_exchange.exception.UserNotFoundException;
import com.example.crypto_exchange.repository.UserCredentialRepository;
import com.example.crypto_exchange.repository.UserRepository;
import com.example.crypto_exchange.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCredentialRepository userCredentialRepository;

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByUserCredentialEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public UserCredential findUserCredentialByEmail(String email) {
        return userCredentialRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public void deleteUserById(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
