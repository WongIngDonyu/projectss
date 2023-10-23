package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserRoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRoleService <I extends UUID>{
    void delete(UserRoleDto userRole);

    void delete(UUID id);

    List<UserRoleDto> getAll();

    Optional<UserRoleDto> findUserRole(UUID id);

    UserRoleDto add(UserRoleDto userRole);
    UserRoleDto update(UserRoleDto userRole);
}
