package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ModelDto;

import java.util.List;
import java.util.Optional;

public interface ModelService <I extends Number>{
    void delete(ModelDto model);

    void delete(Integer id);

    List<ModelDto> getAll();

    Optional<ModelDto> findModel(Integer id);

    ModelDto add(ModelDto model);
}
