package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ToyDto;

import java.util.List;
import java.util.Optional;

public interface ToyService <I extends Number>{
    ToyDto add(ToyDto toyDto);

    void expel(Integer id);

    void expel(ToyDto toy);

    ToyDto register(ToyDto toyDto);

    Optional<ToyDto> findToy(Integer id);

    List<ToyDto> getAll();
}
