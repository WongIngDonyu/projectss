package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.UserDto;
import com.example.springdatabasicdemo.repositories.UserRepository;
import com.example.springdatabasicdemo.services.UserRoleService;
import com.example.springdatabasicdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService<Integer> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void delete(UserDto user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public Optional<UserDto> findUser(Integer id) {
        return Optional.empty();
    }

    @Override
    public UserDto add(UserDto user) {
        return null;
    }
}
