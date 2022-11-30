package com.example.crypto_exchange.mapper;

import com.example.crypto_exchange.entity.dto.UserDto;
import com.example.crypto_exchange.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDto userToUserDTO(User user);
}
