package com.example.crypto_exchange.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "crypto-wallet")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CryptoWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BTC")
    private Double BTC;

    @Column(name = "ETH")
    private Double ETH;

    @Column(name = "SOL")
    private Double SOL;
}
