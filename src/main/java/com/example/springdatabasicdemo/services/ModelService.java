package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ModelDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelService <I extends Number>{
    void delete(ModelDto model);

    void delete(UUID id);

    List<ModelDto> getAll();

    Optional<ModelDto> findModel(UUID id);

    ModelDto add(ModelDto model);

    void update(UUID id, ModelDto modelDto);
}
