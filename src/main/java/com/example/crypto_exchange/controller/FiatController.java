package com.example.crypto_exchange.controller;

import com.example.crypto_exchange.entity.dto.request.FiatDepositRequestDto;
import com.example.crypto_exchange.service.FiatWalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@SecurityRequirement(name = "TOKEN")
@RequiredArgsConstructor
@RequestMapping("/fiat")

public class FiatController {

    private final FiatWalletService fiatWalletService;

    @Operation(summary = "Deposit RUB")
    @PostMapping("/deposit/RUB")
    public ResponseEntity<?> depositRub(@Valid @RequestBody FiatDepositRequestDto dto) {
        fiatWalletService.depositRub(dto.getAmountOfMoneyToDeposit());
        return ResponseEntity.ok("Successful operation");
    }

    @Operation(summary = "Deposit USD")
    @PostMapping("/deposit/USD")
    public ResponseEntity<?> depositUsd(@Valid @RequestBody FiatDepositRequestDto dto) {
        fiatWalletService.depositUsd(dto.getAmountOfMoneyToDeposit());
        return ResponseEntity.ok("Successful operation");
    }

    @Operation(summary = "Deposit EUR")
    @PostMapping("/deposit/EUR")
    public ResponseEntity<?> depositEur(@Valid @RequestBody FiatDepositRequestDto dto) {
        fiatWalletService.depositEur(dto.getAmountOfMoneyToDeposit());
        return ResponseEntity.ok("Successful operation");
    }

    @Operation(summary = "Withdraw RUB")
    @PostMapping("/withdraw/RUB")
    public ResponseEntity<?> withdrawRub(@Valid @RequestBody FiatDepositRequestDto dto) {
        fiatWalletService.withdrawRub(dto.getAmountOfMoneyToDeposit());
        return ResponseEntity.ok("Successful operation");
    }

    @Operation(summary = "Withdraw USD")
    @PostMapping("/withdraw/USD")
    public ResponseEntity<?> withdrawUsd(@Valid @RequestBody FiatDepositRequestDto dto) {
        fiatWalletService.withdrawUsd(dto.getAmountOfMoneyToDeposit());
        return ResponseEntity.ok("Successful operation");
    }

    @Operation(summary = "Withdraw EUR")
    @PostMapping("/withdraw/EUR")
    public ResponseEntity<?> withdrawEur(@Valid @RequestBody FiatDepositRequestDto dto) {
        fiatWalletService.withdrawEur(dto.getAmountOfMoneyToDeposit());
        return ResponseEntity.ok("Successful operation");
    }
}
