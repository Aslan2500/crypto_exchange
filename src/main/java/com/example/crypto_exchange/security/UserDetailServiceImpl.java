package com.example.crypto_exchange.security;

import com.example.crypto_exchange.entity.UserCredential;
import com.example.crypto_exchange.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredential userCredential = userService.findUserCredentialByEmail(username);
        return User
                .withUsername(userCredential.getEmail())
                .password(userCredential.getPassword())
                .authorities(userCredential.getRole().getAuthority())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
