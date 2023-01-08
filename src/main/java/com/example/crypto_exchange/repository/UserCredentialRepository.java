package com.example.crypto_exchange.repository;

import com.example.crypto_exchange.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {

    Optional<UserCredential> findByEmail(String email);
    Optional<UserCredential> findByPhoneNumber(String phoneNumber);
}
