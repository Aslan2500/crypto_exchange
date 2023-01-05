package com.example.crypto_exchange.entity.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Model for user authentication")
@Getter
@Setter
public class AuthenticationRequestDto {

    private String login;

    private String password;
}
