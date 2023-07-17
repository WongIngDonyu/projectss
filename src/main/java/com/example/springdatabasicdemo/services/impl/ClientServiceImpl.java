package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ClientDto;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.repositories.ClientRepository;
import com.example.springdatabasicdemo.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService<Integer> {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void delete(ClientDto client){
        clientRepository.deleteById(client.getId());
    }

    @Override
    public void delete(Integer id){
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDto> getAll() {
        return clientRepository.findAll().stream().map((c) -> modelMapper.map(c, ClientDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ClientDto> findClient(Integer id){
        return Optional.ofNullable(modelMapper.map(clientRepository.findById(id), ClientDto.class));
    }

    @Override
    public ClientDto add(ClientDto client) {
        Client c = modelMapper.map(client, Client.class);

        return modelMapper.map(clientRepository.save(c), ClientDto.class);
    }
}
