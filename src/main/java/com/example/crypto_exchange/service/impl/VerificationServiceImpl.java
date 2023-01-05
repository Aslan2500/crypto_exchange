package com.example.crypto_exchange.service.impl;

import com.example.crypto_exchange.entity.Verification;
import com.example.crypto_exchange.entity.dto.request.VerifyUserRequestDto;
import com.example.crypto_exchange.entity.enums.VerificationType;
import com.example.crypto_exchange.exception.ResourceNotFoundException;
import com.example.crypto_exchange.repository.UserCredentialRepository;
import com.example.crypto_exchange.repository.VerificationRepository;
import com.example.crypto_exchange.service.VerificationService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.example.crypto_exchange.util.PhoneUtil.convertToStandardFormat;

@Service
@RequiredArgsConstructor
@Transactional
public class VerificationServiceImpl implements VerificationService {

    private static final int CODE_EXPIRATION_TIME = 5;

    private final VerificationRepository verificationRepository;
    private final UserCredentialRepository userCredentialRepository;

    @Override
    public Verification sendVerificationSmsCode(String phoneNumber) {
        String validatedPhoneNumber = convertToStandardFormat(phoneNumber);
        Verification verification = Verification.builder()
                .receiver(validatedPhoneNumber)
                .verificationCode(RandomStringUtils.randomNumeric(6))
                .verificationType(VerificationType.MOBILE_PHONE)
                .codeExpiration(Timestamp.valueOf(LocalDateTime.now().plusMinutes(CODE_EXPIRATION_TIME))).build();
        return verificationRepository.save(verification);
    }

    @Override
    public Boolean verifyRegistrationBySms(VerifyUserRequestDto dto) {
        String validatedPhoneNumber = convertToStandardFormat(dto.getPhoneNumber());
        Verification verification =
                verificationRepository.findByReceiverAndVerificationCode(
                        validatedPhoneNumber, dto.getVerificationCode()
                ).orElseThrow(() -> new ResourceNotFoundException("Verification not found for this mobile phone"));
        userCredentialRepository.findByPhoneNumber(validatedPhoneNumber).orElseThrow().setIsVerified(true);
        return !LocalDateTime.now().isAfter((verification.getCodeExpiration()).toLocalDateTime());
    }
}
