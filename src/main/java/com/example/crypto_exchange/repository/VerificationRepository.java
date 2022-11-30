package com.example.crypto_exchange.repository;

import com.example.crypto_exchange.dto.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepository extends JpaRepository<Verification, String> {
}
