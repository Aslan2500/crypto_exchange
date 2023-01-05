package com.example.crypto_exchange.service.impl;

import com.example.crypto_exchange.entity.dto.RegisterUserDto;
import com.example.crypto_exchange.entity.User;
import com.example.crypto_exchange.entity.UserCredential;
import com.example.crypto_exchange.service.RegistrationService;
import com.example.crypto_exchange.service.UserService;
import com.example.crypto_exchange.util.PhoneUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//TODO: Добавить Mapper
@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;

    @Override
    public void registerUser(RegisterUserDto dto) {
        String convertedPhoneNumber = PhoneUtil.convertToStandardFormat(dto.getPhoneNumber());
        String passwordEncoded = new BCryptPasswordEncoder().encode(dto.getPassword());
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .build();
        UserCredential userCredential = UserCredential.builder()
                .email(dto.getEmail())
                .password(passwordEncoded)
                .passport(dto.getPassport())
                .phoneNumber(convertedPhoneNumber)
                .securityQuestion(dto.getSecurityQuestion())
                .securityAnswer(dto.getSecurityAnswer())
                .emailIsVerified(false)
                .role(dto.getRole())
                .build();
        user.setUserCredential(userCredential);
        userService.registerUser(user);
    }
}
