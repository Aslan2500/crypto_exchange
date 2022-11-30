package com.example.crypto_exchange.mapper;

import com.example.crypto_exchange.dto.UserDTO;
import com.example.crypto_exchange.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDTO entityToDTO(User user);
}
