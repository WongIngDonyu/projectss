package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.UserRoleDto;
import com.example.springdatabasicdemo.models.UserRole;
import com.example.springdatabasicdemo.repositories.UserRoleRepository;
import com.example.springdatabasicdemo.services.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService<Integer> {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void delete(UserRoleDto userRole) {
        userRoleRepository.deleteById(userRole.getId());
    }

    @Override
    public void delete(UUID id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public List<UserRoleDto> getAll() {
        return userRoleRepository.findAll().stream().map((m)->modelMapper.map(m, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UserRoleDto> findUserRole(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRoleRepository.findById(id), UserRoleDto.class));
    }

    @Override
    public UserRoleDto add(UserRoleDto userRole) {
        UserRole u = modelMapper.map(userRole, UserRole.class);
        return modelMapper.map(userRoleRepository.save(u), UserRoleDto.class);
    }


}
