package com.example.crypto_exchange.controller;

import com.example.crypto_exchange.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @SecurityRequirement(name = "TOKEN")
    @Operation(summary = "Delete user by userId")
    @ApiResponse(responseCode = "200", description = "The user was deleted successfully")
    @ApiResponse(responseCode = "400", description = "The user with the given id wasn't found")
    @ApiResponse(responseCode = "403", description = "Your role doesn't have access")
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
