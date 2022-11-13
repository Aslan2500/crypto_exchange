package com.example.crypto_exchange.converter;

import com.example.crypto_exchange.dto.UserDTO;
import com.example.crypto_exchange.entity.User;

import java.util.List;

public interface UserConverter {

    UserDTO entityToDTO(User user);

    List<UserDTO> userListToDtoList(List<User> userList);
}
