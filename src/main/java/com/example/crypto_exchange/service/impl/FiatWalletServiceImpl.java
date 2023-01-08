package com.example.crypto_exchange.service.impl;

import com.example.crypto_exchange.entity.FiatWallet;
import com.example.crypto_exchange.entity.User;
import com.example.crypto_exchange.exception.NotEnoughMoneyException;
import com.example.crypto_exchange.exception.WrongCurrencyInputException;
import com.example.crypto_exchange.repository.FiatWalletRepository;
import com.example.crypto_exchange.service.FiatWalletService;
import com.example.crypto_exchange.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FiatWalletServiceImpl implements FiatWalletService {

    private final UserService userService;
    private final FiatWalletRepository fiatWalletRepository;

    @Override
    public void depositRub(Double rub) {
        User user = getCurrentUser();
        depositValidation(user, rub);
        FiatWallet fiatWallet = user.getFiatWallet();
        fiatWallet.setRUB(fiatWallet.getRUB() + rub);
        fiatWalletRepository.saveAndFlush(fiatWallet);
    }

    @Override
    public void depositUsd(Double usd) {
        User user = getCurrentUser();
        depositValidation(user, usd);
        FiatWallet fiatWallet = user.getFiatWallet();
        fiatWallet.setUSD(fiatWallet.getUSD() + usd);
        fiatWalletRepository.saveAndFlush(fiatWallet);
    }

    @Override
    public void depositEur(Double eur) {
        User user = getCurrentUser();
        depositValidation(user, eur);
        FiatWallet fiatWallet = user.getFiatWallet();
        fiatWallet.setEUR(fiatWallet.getEUR() + eur);
        fiatWalletRepository.saveAndFlush(fiatWallet);
    }

    @Override
    public void withdrawRub(Double rub) {
        User user = getCurrentUser();
        FiatWallet fiatWallet = user.getFiatWallet();
        if (fiatWallet.getRUB() < rub) {
            throw new NotEnoughMoneyException("Not enough money");
        }
        fiatWallet.setRUB(fiatWallet.getRUB() - rub);
        fiatWalletRepository.saveAndFlush(fiatWallet);
    }

    @Override
    public void withdrawUsd(Double usd) {
        User user = getCurrentUser();
        FiatWallet fiatWallet = user.getFiatWallet();
        if (fiatWallet.getUSD() < usd) {
            throw new NotEnoughMoneyException("Not enough money");
        }
        fiatWallet.setUSD(fiatWallet.getUSD() - usd);
        fiatWalletRepository.saveAndFlush(fiatWallet);
    }

    @Override
    public void withdrawEur(Double eur) {
        User user = getCurrentUser();
        FiatWallet fiatWallet = user.getFiatWallet();
        if (fiatWallet.getEUR() < eur) {
            throw new NotEnoughMoneyException("Not enough money");
        }
        fiatWallet.setEUR(fiatWallet.getEUR() - eur);
        fiatWalletRepository.saveAndFlush(fiatWallet);
    }

    private void depositValidation(User user, Double amountOfMoney) {
        if (amountOfMoney <= 1) {
            throw new WrongCurrencyInputException("You can't deposit that amount of money");
        } else if (!user.getUserCredential().getIsVerified() && amountOfMoney > 10000) {
            throw new WrongCurrencyInputException("To deposit more than 10.000 you have to verify your account");
        }
    }

    private User getCurrentUser() {
        return userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
