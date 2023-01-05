package com.example.crypto_exchange.entity.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Model for password recovery")
@Getter
@Setter
public class PasswordRecoveryDto {

    private String phoneNumber;
    private String newPassword;
    private String securityAnswer;
}
