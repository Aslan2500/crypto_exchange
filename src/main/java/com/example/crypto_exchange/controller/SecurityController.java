package com.example.crypto_exchange.controller;

import com.example.crypto_exchange.service.VerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service/security")
@RequiredArgsConstructor
public class SecurityController {

    private final VerificationService verificationService;

    @GetMapping("session/otp/phone")
    public ResponseEntity<?> sendVerificationSmsCode(String phoneNumber) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("session/phone")
    public ResponseEntity<?> verifyUserBySms(String phoneNumber, String code) {
        return null;
    }
}
