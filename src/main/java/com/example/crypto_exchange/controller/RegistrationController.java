package com.example.crypto_exchange.controller;

import com.example.crypto_exchange.dto.RegisterUserDTO;
import com.example.crypto_exchange.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;


    @SecurityRequirement(name = "TOKEN")
    @Operation(summary = "Register user")
    @ApiResponse(responseCode = "200", description = "The user was created successfully")
    @ApiResponse(responseCode = "400", description = "Incorrect data transmitted")
    @ApiResponse(responseCode = "403", description = "Your role doesn't have access")
    @PostMapping
    public ResponseEntity<Void> registerUser(@Valid @RequestBody RegisterUserDTO dto) {
        userService.registerUser(dto);
        return ResponseEntity.ok().build();
    }

    @SecurityRequirement(name = "TOKEN")
    @Operation(summary = "Delete user by userId")
    @ApiResponse(responseCode = "200", description = "The user was deleted successfully")
    @ApiResponse(responseCode = "400", description = "The user with the given id wasn't found")
    @ApiResponse(responseCode = "403", description = "Your role doesn't have access")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
