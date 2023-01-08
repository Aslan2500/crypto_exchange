package com.example.crypto_exchange.service;

public interface FiatWalletService {

    void depositRub(Double rub);
    void depositUsd(Double usd);
    void depositEur(Double eur);
    void withdrawRub(Double rub);
    void withdrawUsd(Double usd);
    void withdrawEur(Double eur);
}
