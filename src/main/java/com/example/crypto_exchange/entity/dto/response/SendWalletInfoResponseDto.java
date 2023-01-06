package com.example.crypto_exchange.entity.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Model for sending info about amount of money and cryptocurrency")
@Getter
@Setter
public class SendWalletInfoResponseDto {

    private Double BTC;
    private Double ETH;
    private Double SOL;
    private Double RUB;
    private Double USD;
    private Double EUR;
}
