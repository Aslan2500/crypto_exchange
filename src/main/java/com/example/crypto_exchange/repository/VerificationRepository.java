package com.example.crypto_exchange.repository;

import com.example.crypto_exchange.entity.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationRepository extends JpaRepository<Verification, String> {

    Optional<Verification> findByReceiverAndVerificationCode(String receiver, String verificationCode);
}
