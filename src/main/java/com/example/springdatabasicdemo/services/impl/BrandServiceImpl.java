package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BrandDto;
import com.example.springdatabasicdemo.dtos.ClientDto;
import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.repositories.BrandRepository;
import com.example.springdatabasicdemo.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService<Integer> {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void delete(BrandDto brand) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<BrandDto> getAll() {
        return null;
    }

    @Override
    public Optional<BrandDto> findBrand(Integer id) {
        return Optional.empty();
    }

    @Override
    public BrandDto add(BrandDto brand) {
        Brand b = modelMapper.map(brand, Brand.class);
        b.setCreated(LocalDateTime.now());
        return modelMapper.map(brandRepository.save(b), BrandDto.class);
    }
}
