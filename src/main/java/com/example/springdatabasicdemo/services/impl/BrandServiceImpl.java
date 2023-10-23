package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BrandDto;
import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.repositories.BrandRepository;
import com.example.springdatabasicdemo.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService<Integer> {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void delete(BrandDto brand) {
        brandRepository.deleteById(brand.getId());
    }

    @Override
    public void delete(UUID id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<BrandDto> getAll() {
        return brandRepository.findAll().stream().map((b) -> modelMapper.map(b, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<BrandDto> findBrand(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id), BrandDto.class));
    }

    @Override
    public BrandDto add(BrandDto brand) {
        Brand b = modelMapper.map(brand, Brand.class);
        b.setCreated(LocalDateTime.now());
        return modelMapper.map(brandRepository.save(b), BrandDto.class);
    }

    @Override
    public void update(UUID id, BrandDto brandDto) {
        Brand brand = brandRepository.findById(id).orElse(null);
        if(brand!=null){
            brand.setName(brandDto.getName());
            brand.setModified(LocalDateTime.now());
            brandRepository.save(brand);
        }
        else {
            throw new NoSuchElementException("Model not found. id:" + id);
        }
    }

}
