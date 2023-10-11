package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserRoleDto;

import java.util.List;
import java.util.Optional;

public interface UserRoleService <I extends Number>{
    void delete(UserRoleDto userRole);

    void delete(Integer id);

    List<UserRoleDto> getAll();

    Optional<UserRoleDto> findUserRole(Integer id);

    UserRoleDto add(UserRoleDto userRole);
}
