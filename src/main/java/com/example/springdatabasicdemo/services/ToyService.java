package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ToyDto;

public interface ToyService <I extends Number>{
    ToyDto add(ToyDto toyDto);
}
