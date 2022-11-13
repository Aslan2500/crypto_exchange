package com.example.crypto_exchange.controller;

import com.example.crypto_exchange.dto.RegisterUserDTO;
import com.example.crypto_exchange.service.UserService;
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

    @PostMapping
    public ResponseEntity<Void> registerUser(@Valid @RequestBody RegisterUserDTO dto) {
        userService.registerUser(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
