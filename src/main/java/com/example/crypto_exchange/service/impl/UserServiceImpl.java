package com.example.crypto_exchange.service.impl;

import com.example.crypto_exchange.entity.User;
import com.example.crypto_exchange.entity.UserCredential;
import com.example.crypto_exchange.entity.dto.request.PasswordRecoveryDto;
import com.example.crypto_exchange.exception.SecurityAnswerException;
import com.example.crypto_exchange.exception.UserNotFoundException;
import com.example.crypto_exchange.repository.UserRepository;
import com.example.crypto_exchange.service.UserCredentialService;
import com.example.crypto_exchange.service.UserService;
import com.example.crypto_exchange.util.PhoneUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCredentialService userCredentialService;

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
        return userCredentialService.findUserCredentialByEmail(email);
    }

    @Override
    public void deleteUserById(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public void recoverPassword(PasswordRecoveryDto dto) {
        String convertedPhoneNumber = PhoneUtil.convertToStandardFormat(dto.getPhoneNumber());
        UserCredential userCredential = userCredentialService.findUserCredentialByPhoneNumber(convertedPhoneNumber);
        if (!dto.getSecurityAnswer().equals(userCredential.getSecurityAnswer())) {
            throw new SecurityAnswerException("Security answer is wrong");
        }
        String passwordEncoded = new BCryptPasswordEncoder().encode(dto.getNewPassword());
        userCredential.setPassword(passwordEncoded);
    }
}
