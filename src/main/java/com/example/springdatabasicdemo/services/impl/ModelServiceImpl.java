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
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl  implements ModelService<UUID> {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private BrandRepository brandRepository;


    @Override
    public void delete(ModelDto model) {
        modelRepository.deleteById(model.getId());
    }

    @Override
    public void delete(UUID id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<ModelDto> getAll() {
        return modelRepository.findAll().stream().map((m)->modelMapper.map(m, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ModelDto> findModel(UUID id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id), ModelDto.class));
    }

    @Override
    public ModelDto add(ModelDto model, BrandDto brandDto) {
        Model m = modelMapper.map(model, Model.class);
        Brand b = brandRepository.findById(brandDto.getId()).orElse(null);
        if (b != null) {
            m.setBrand(b);
        }
        else {
            throw new NoSuchElementException("Brand not found");
        }
        m.setCreated(LocalDateTime.now());


        return modelMapper.map(modelRepository.save(m), ModelDto.class);
    }

    @Override
    public ModelDto update(ModelDto modelDto) {
        Optional<Model> dbModel = modelRepository.findById(modelDto.getId());
        if (dbModel.isEmpty()) {
            throw new NoSuchElementException("Model not found");
        } else {
            Model model = dbModel.get();
            modelMapper.map(modelDto, model);
            model.setModified(LocalDateTime.now());
            return modelMapper.map(modelRepository.save(model), ModelDto.class);
        }
    }

}
