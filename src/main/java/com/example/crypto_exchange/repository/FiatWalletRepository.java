package com.example.crypto_exchange.repository;

import com.example.crypto_exchange.entity.FiatWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiatWalletRepository extends JpaRepository<FiatWallet, Long> {
}
