package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BrandDto;
import com.example.springdatabasicdemo.dtos.ModelDto;
import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.models.Model;
import com.example.springdatabasicdemo.repositories.BrandRepository;
import com.example.springdatabasicdemo.repositories.ModelRepository;
import com.example.springdatabasicdemo.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class ModelServiceImpl  implements ModelService<Integer> {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private BrandRepository brandRepository;


    @Override
    public void delete(ModelDto model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<ModelDto> getAll() {
        return null;
    }

    @Override
    public Optional<ModelDto> findModel(Integer id) {
        return Optional.empty();
    }

    @Override
    public ModelDto add(ModelDto model) {
        Model m = modelMapper.map(model, Model.class);
        if(model.getBrand().getId()!=0){
            Brand b = brandRepository.findById(model.getBrand().getId()).get();
            m.setBrand(b);
        }

        m.setCreated(LocalDateTime.now());
        return modelMapper.map(modelRepository.save(m), ModelDto.class);
    }
}
