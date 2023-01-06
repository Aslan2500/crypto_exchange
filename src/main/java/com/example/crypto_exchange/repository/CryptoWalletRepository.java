package com.example.crypto_exchange.repository;

import com.example.crypto_exchange.entity.CryptoWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoWalletRepository extends JpaRepository<CryptoWallet, Long> {
}
