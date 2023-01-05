package com.example.crypto_exchange.controller;

import com.example.crypto_exchange.entity.UserCredential;
import com.example.crypto_exchange.entity.dto.request.AuthenticationRequestDto;
import com.example.crypto_exchange.security.jwt.JwtTokenProvider;
import com.example.crypto_exchange.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;


    @Operation(summary = "Login")
    @ApiResponse(responseCode = "200", description = "Login to the Application was successful")
    @ApiResponse(responseCode = "403", description = "Invalid email/password combination")
    @PostMapping("/login")
    public ResponseEntity authenticate(@RequestBody AuthenticationRequestDto dto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword()));
            UserCredential userCredential =  userService.findUserCredentialByEmail(dto.getLogin());
            String token = jwtTokenProvider.createToken(dto.getLogin(), userCredential.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", dto.getLogin());
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (UsernameNotFoundException ex) {
            return new ResponseEntity("Invalid login/password combination", HttpStatus.FORBIDDEN);
        }
    }

    @SecurityRequirement(name = "TOKEN")
    @Operation(summary = "Logout")
    @ApiResponse(responseCode = "200", description = "Exiting the application was successful")
    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, null);
    }
}
