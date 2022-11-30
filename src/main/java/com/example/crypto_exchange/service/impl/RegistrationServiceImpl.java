package com.example.crypto_exchange.service.impl;

import com.example.crypto_exchange.dto.RegisterUserDTO;
import com.example.crypto_exchange.entity.User;
import com.example.crypto_exchange.entity.UserCredential;
import com.example.crypto_exchange.repository.UserRepository;
import com.example.crypto_exchange.service.RegistrationService;
import com.example.crypto_exchange.util.PhoneUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    @Override
    public void registerUser(RegisterUserDTO dto) {
        String convertedPhoneNumber = PhoneUtil.convertToStandardFormat(dto.getPhoneNumber());
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .build();
        UserCredential userCredential = UserCredential.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .passport(dto.getPassport())
                .phoneNumber(convertedPhoneNumber)
                .securityQuestion(dto.getSecurityQuestion())
                .securityAnswer(dto.getSecurityAnswer())
                .isVerified(false)
                .role(dto.getRole())
                .build();
        user.setUserCredential(userCredential);
        userRepository.save(user);
    }
}
