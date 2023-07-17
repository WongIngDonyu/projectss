package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ToyDto;
import com.example.springdatabasicdemo.models.Toy;

import java.util.List;
import java.util.Optional;

public interface ToyService <I extends Number>{
    ToyDto add(ToyDto toyDto);

    void delete(Integer id);

    void delete(ToyDto toy);

    Optional<ToyDto> findToy(Integer id);

    List<ToyDto> getAll();

}
