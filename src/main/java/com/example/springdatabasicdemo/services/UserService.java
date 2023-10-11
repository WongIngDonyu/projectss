package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService <I extends Number>{
    void delete(UserDto user);

    void delete(Integer id);

    List<UserDto> getAll();

    Optional<UserDto> findUser(Integer id);

    UserDto add(UserDto user);
}
