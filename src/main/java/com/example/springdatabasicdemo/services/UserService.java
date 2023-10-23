package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService <I extends Number>{
    void delete(UserDto user);

    void delete(UUID id);

    List<UserDto> getAll();

    Optional<UserDto> findUser(UUID id);

    UserDto add(UserDto user);
}
