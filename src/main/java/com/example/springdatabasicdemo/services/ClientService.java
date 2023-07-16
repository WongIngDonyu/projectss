package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ClientDto;
import com.example.springdatabasicdemo.dtos.ReviewDto;

import java.util.List;
import java.util.Optional;

public interface ClientService <I extends Number> {
    void expel(ClientDto client);

    void expel(Integer id);

    List<ClientDto> getAll();

    Optional<ClientDto> findClient(Integer id);

    ClientDto register(ClientDto client);

}
