package com.example.crypto_exchange.converter.impl;

import com.example.crypto_exchange.converter.UserConverter;
import com.example.crypto_exchange.dto.UserDTO;
import com.example.crypto_exchange.entity.User;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserConverterImpl implements UserConverter {

    @Override
    public UserDTO entityToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .build();
    }

    @Override
    public List<UserDTO> userListToDtoList(List<User> userList) {
        if (Objects.isNull(userList)) {
            return Collections.emptyList();
        }
        return userList.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}
