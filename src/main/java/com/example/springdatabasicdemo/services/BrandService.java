package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BrandDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService <I extends Number>{
    void delete(BrandDto brand);

    void delete(UUID id);

    List<BrandDto> getAll();

    Optional<BrandDto> findBrand(UUID id);

    BrandDto add(BrandDto brand);
    void update(UUID id, BrandDto brand);
}
