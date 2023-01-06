package com.example.crypto_exchange.service;

import com.example.crypto_exchange.entity.dto.response.SendWalletInfoResponseDto;

public interface WalletService {

    SendWalletInfoResponseDto getWalletInfo();
}
