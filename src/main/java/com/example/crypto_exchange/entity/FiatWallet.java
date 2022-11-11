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

@Table(name = "fiat-wallet")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FiatWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RUB")
    private Double RUB;

    @Column(name = "USD")
    private Double USD;

    @Column(name = "EUR")
    private Double EUR;
}
