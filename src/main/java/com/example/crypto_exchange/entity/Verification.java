package com.example.crypto_exchange.entity;

import com.example.crypto_exchange.entity.enums.VerificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "verification")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Verification {

    @Id
    @Column(name = "receiver")
    private String receiver;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "code_expiration", nullable = true)
    private Timestamp codeExpiration;

    @Column(name = "verification_type")
    @Enumerated
    private VerificationType verificationType;
}
