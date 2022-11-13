package com.example.crypto_exchange.service.impl;

import com.example.crypto_exchange.dto.RegisterUserDTO;
import com.example.crypto_exchange.entity.User;
import com.example.crypto_exchange.entity.UserCredential;
import com.example.crypto_exchange.exception.UserNotFoundException;
import com.example.crypto_exchange.repository.UserCredentialRepository;
import com.example.crypto_exchange.repository.UserRepository;
import com.example.crypto_exchange.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCredentialRepository userCredentialRepository;

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
    public void registerUser(RegisterUserDTO dto) {
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .build();
        UserCredential userCredential = UserCredential.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();
        user.setUserCredential(userCredential);
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
