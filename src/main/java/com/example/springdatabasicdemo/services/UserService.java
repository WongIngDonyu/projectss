package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserDto;
import com.example.springdatabasicdemo.dtos.UserRoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService <I extends UUID>{
    void delete(UserDto user);

    void delete(UUID id);

    List<UserDto> getAll();

    Optional<UserDto> findUser(UUID id);

    UserDto add(UserDto user, UserRoleDto  userRoleDto);
    UserDto update(UserDto user);
}
