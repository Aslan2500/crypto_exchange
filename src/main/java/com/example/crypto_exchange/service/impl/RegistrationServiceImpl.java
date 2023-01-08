package com.example.crypto_exchange.service.impl;

import com.example.crypto_exchange.entity.CryptoWallet;
import com.example.crypto_exchange.entity.FiatWallet;
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

        CryptoWallet cryptoWallet = new CryptoWallet();
        cryptoWallet.setBTC(0.0);
        cryptoWallet.setETH(0.0);
        cryptoWallet.setSOL(0.0);

        FiatWallet fiatWallet = new FiatWallet();
        fiatWallet.setRUB(0.0);
        fiatWallet.setUSD(0.0);
        fiatWallet.setEUR(0.0);

        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .cryptoWallet(cryptoWallet)
                .fiatWallet(fiatWallet)
                .build();
        UserCredential userCredential = UserCredential.builder()
                .email(dto.getEmail())
                .password(passwordEncoded)
                .passport(dto.getPassport())
                .phoneNumber(convertedPhoneNumber)
                .securityQuestion(dto.getSecurityQuestion())
                .securityAnswer(dto.getSecurityAnswer())
                .isVerified(false)
                .role(dto.getRole())
                .build();
        user.setUserCredential(userCredential);
        userService.registerUser(user);
    }
}
