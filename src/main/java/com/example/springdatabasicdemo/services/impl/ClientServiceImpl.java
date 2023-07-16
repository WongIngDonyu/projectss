package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ClientDto;
import com.example.springdatabasicdemo.dtos.StudentDto;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Group;
import com.example.springdatabasicdemo.models.Student;
import com.example.springdatabasicdemo.repositories.ClientRepository;
import com.example.springdatabasicdemo.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService<Integer> {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDto register(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        return modelMapper.map(clientRepository.save(client), ClientDto.class);
    }
}
