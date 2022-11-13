package com.example.crypto_exchange.dto;

import com.example.crypto_exchange.entity.enums.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class RegisterUserDTO {

    @Pattern(regexp = "^[A-Za-z]+$",message = "Name may not be empty")
    private String name;

    @Pattern(regexp = "^[A-Za-z]+$",message = "Surname may not be empty")
    private String surname;

    @Email
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{3,}$")
    private String password;

    private Role role;
}
