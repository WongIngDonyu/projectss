package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.UserDto;
import com.example.springdatabasicdemo.dtos.UserRoleDto;
import com.example.springdatabasicdemo.models.User;
import com.example.springdatabasicdemo.models.UserRole;
import com.example.springdatabasicdemo.repositories.UserRepository;
import com.example.springdatabasicdemo.repositories.UserRoleRepository;
import com.example.springdatabasicdemo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService<UUID> {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void delete(UserDto user) {
        userRepository.deleteById(user.getId());
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map((m)->modelMapper.map(m, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findUser(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRepository.findById(id), UserDto.class));
    }

    @Override
    public UserDto add(UserDto user, UserRoleDto userRoleDto) {
        User u = modelMapper.map(user, User.class);
        UserRole userRole = userRoleRepository.findById(userRoleDto.getId()).orElse(null);
        if (userRole != null) {
            u.setUserRole(userRole);
        }
        else {
            throw new NoSuchElementException("UserRole not found");
        }
        u.setCreated(LocalDateTime.now());
        return modelMapper.map(userRepository.save(u), UserDto.class);
    }

    @Override
    public UserDto update(UserDto userDto) {
        Optional<User> dbUser = userRepository.findById(userDto.getId());
        if (dbUser.isEmpty()) {
            throw new NoSuchElementException("User not found");
        } else {
            User user1 = dbUser.get();
            modelMapper.map(userDto, user1);
            user1.setModified(LocalDateTime.now());
            return modelMapper.map(userRepository.save(user1), UserDto.class);
        }
    }
}
