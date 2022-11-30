package com.example.crypto_exchange.entity.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Schema(description = "Model for user verification")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VerifyUserRequestDto {

    @Pattern(regexp = "^[0-9]{11}$",
            message = "Mobile phone must be the length of 11 and contain only digits")
    private String phoneNumber;
    private String verificationCode;
}
