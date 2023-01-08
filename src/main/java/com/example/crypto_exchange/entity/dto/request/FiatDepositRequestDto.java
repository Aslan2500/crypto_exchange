package com.example.crypto_exchange.entity.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

//TODO: Добавить ограничения на отрицательные числа
@Schema(description = "Model to deposit fiat currency")
@Getter
@Setter
public class FiatDepositRequestDto {

    Double amountOfMoneyToDeposit;
}
