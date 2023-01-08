package com.example.crypto_exchange.controller;

import com.example.crypto_exchange.entity.Verification;
import com.example.crypto_exchange.entity.dto.request.VerifyUserRequestDto;
import com.example.crypto_exchange.entity.dto.response.SendSmsVerificationCodeResponseDto;
import com.example.crypto_exchange.service.VerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service/security")
@RequiredArgsConstructor
public class SecurityController {

    private final VerificationService verificationService;

    @GetMapping("session/otp/phone")
    public ResponseEntity<SendSmsVerificationCodeResponseDto> sendVerificationSmsCode(@RequestParam String phoneNumber) {
        Verification verification = verificationService.sendVerificationSmsCode(phoneNumber);
        return ResponseEntity.ok(
                SendSmsVerificationCodeResponseDto.builder().verificationCode(verification.getVerificationCode())
                        .build());
    }

    @PostMapping("session/phone")
    public ResponseEntity<?> verifyUserBySms(@RequestBody VerifyUserRequestDto dto) {
        if (!verificationService.verifyRegistrationBySms(dto)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok("Successfully verified");
    }
}
