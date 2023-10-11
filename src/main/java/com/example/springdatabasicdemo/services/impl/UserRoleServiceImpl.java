package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.UserRoleDto;
import com.example.springdatabasicdemo.repositories.UserRoleRepository;
import com.example.springdatabasicdemo.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService<Integer> {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void delete(UserRoleDto userRole) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<UserRoleDto> getAll() {
        return null;
    }

    @Override
    public Optional<UserRoleDto> findUserRole(Integer id) {
        return Optional.empty();
    }

    @Override
    public UserRoleDto add(UserRoleDto userRole) {
        return null;
    }
}
