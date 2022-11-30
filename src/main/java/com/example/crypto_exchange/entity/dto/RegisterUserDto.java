package com.example.crypto_exchange.entity.dto;

import com.example.crypto_exchange.entity.enums.Role;
import com.example.crypto_exchange.util.PhoneUtil;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class RegisterUserDto {

    @Pattern(regexp = "^[A-Za-z]+$",message = "Name may not be empty")
    @NotNull(message = "This field can't be empty")
    private String name;
    @Pattern(regexp = "^[A-Za-z]+$",message = "Surname may not be empty")
    @NotNull(message = "This field can't be empty")
    private String surname;
    @Email
    @NotNull(message = "This field can't be empty")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{3,}$")
    @NotNull(message = "This field can't be empty")
    private String password;
    @NotNull(message = "This field can't be empty")
    private String passport;
    @Pattern(regexp = PhoneUtil.PHONE_REGEX)
    @NotNull(message = "This field can't be empty")
    private String phoneNumber;
    @NotNull(message = "This field can't be empty")
    private String securityQuestion;
    @NotNull(message = "This field can't be empty")
    private String securityAnswer;
    private Role role;
}
