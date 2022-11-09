package com.example.crypto_exchange.service.impl;

import com.example.crypto_exchange.repository.UserRepository;
import com.example.crypto_exchange.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
}
