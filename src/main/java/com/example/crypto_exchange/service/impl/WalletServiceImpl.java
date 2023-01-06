package com.example.crypto_exchange.service.impl;

import com.example.crypto_exchange.entity.CryptoWallet;
import com.example.crypto_exchange.entity.FiatWallet;
import com.example.crypto_exchange.entity.User;
import com.example.crypto_exchange.entity.dto.response.SendWalletInfoResponseDto;
import com.example.crypto_exchange.service.UserService;
import com.example.crypto_exchange.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WalletServiceImpl implements WalletService {

    private final UserService userService;

    @Override
    public SendWalletInfoResponseDto getWalletInfo() {
        User user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        CryptoWallet cryptoWallet = user.getCryptoWallet();
        FiatWallet fiatWallet = user.getFiatWallet();
        SendWalletInfoResponseDto dto = new SendWalletInfoResponseDto();

        dto.setBTC(cryptoWallet.getBTC());
        dto.setETH(cryptoWallet.getETH());
        dto.setSOL(cryptoWallet.getSOL());
        dto.setEUR(fiatWallet.getEUR());
        dto.setRUB(fiatWallet.getRUB());
        dto.setUSD(fiatWallet.getUSD());

        return dto;
    }
}
