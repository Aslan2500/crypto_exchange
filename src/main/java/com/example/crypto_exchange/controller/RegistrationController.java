package com.example.crypto_exchange.controller;

import com.example.crypto_exchange.entity.dto.RegisterUserDto;
import com.example.crypto_exchange.service.RegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @SecurityRequirement(name = "TOKEN")
    @Operation(summary = "Register user")
    @ApiResponse(responseCode = "200", description = "The user was created successfully")
    @ApiResponse(responseCode = "400", description = "Incorrect data transmitted")
    @ApiResponse(responseCode = "403", description = "Your role doesn't have access")
    @PostMapping
    public ResponseEntity<Void> registerUser(@Valid @RequestBody RegisterUserDto dto) {
        registrationService.registerUser(dto);
        return ResponseEntity.ok().build();
    }
}
