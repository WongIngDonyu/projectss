package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.models.User;
import com.example.springdatabasicdemo.services.dtos.UserDto;
import com.example.springdatabasicdemo.services.dtos.UserRoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService <I extends UUID>{
    void delete(UserDto user);

    void delete(UUID id);

    List<UserDto> getAll();

    Optional<UserDto> findUser(UUID id);

    UserDto add(UserDto user);
    UserDto update(UserDto user);
    User findByUsername (String username);
}
