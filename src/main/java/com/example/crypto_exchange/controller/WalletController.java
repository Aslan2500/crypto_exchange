package com.example.crypto_exchange.controller;

import com.example.crypto_exchange.entity.dto.response.SendWalletInfoResponseDto;
import com.example.crypto_exchange.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "TOKEN")
@RequiredArgsConstructor
@RequestMapping("/account/wallet")
public class WalletController {
    private final WalletService walletService;

    @Operation(summary = "Returns information about user's financials")
    @GetMapping("/main/info")
    public ResponseEntity<SendWalletInfoResponseDto> sendWalletInfo() {
        return ResponseEntity.ok(walletService.getWalletInfo());
    }
}

