package com.example.crypto_exchange.entity.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Schema(description = "Response model for sending verification code")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendSmsVerificationCodeResponseDto {
    private String verificationCode;
}
