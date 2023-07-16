package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ClientDto;
import com.example.springdatabasicdemo.dtos.ReviewDto;

public interface ClientService <I extends Number> {
    ClientDto register(ClientDto client);

}
