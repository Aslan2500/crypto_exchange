package com.example.crypto_exchange.service;

import com.example.crypto_exchange.entity.Verification;
import com.example.crypto_exchange.entity.dto.request.VerifyUserRequestDto;

public interface VerificationService {

    Verification sendVerificationSmsCode(String phoneNumber);

    Boolean verifyRegistrationBySms(VerifyUserRequestDto dto);
}
