package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BrandDto;

import java.util.List;
import java.util.Optional;

public interface BrandService <I extends Number>{
    void delete(BrandDto brand);

    void delete(Integer id);

    List<BrandDto> getAll();

    Optional<BrandDto> findBrand(Integer id);

    BrandDto add(BrandDto brand);
}
