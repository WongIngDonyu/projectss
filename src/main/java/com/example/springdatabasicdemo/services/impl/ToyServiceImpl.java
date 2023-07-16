package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ToyDto;
import com.example.springdatabasicdemo.models.Toy;
import com.example.springdatabasicdemo.repositories.ToyRepository;
import com.example.springdatabasicdemo.services.ToyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToyServiceImpl implements ToyService<Integer> {
    @Autowired
    private ToyRepository toyRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ToyDto add(ToyDto toyDto) {
        Toy toy = modelMapper.map(toyDto, Toy.class);
        return modelMapper.map(toyRepository.save(toy), ToyDto.class);
    }

    @Override
    public void expel(Integer id){
        toyRepository.deleteById(id);
    }

    @Override
    public void expel(ToyDto toy){
        toyRepository.deleteById(toy.getId());
    }

    @Override
    public ToyDto register(ToyDto toyDto){
        Toy toy = modelMapper.map(toyDto, Toy.class);
        return modelMapper.map(toyRepository.save(toy), ToyDto.class);
    }

    @Override
    public Optional<ToyDto> findToy(Integer id){
        return Optional.ofNullable(modelMapper.map(toyRepository.findById(id), ToyDto.class));
    }

    @Override
    public List<ToyDto> getAll() {
        return toyRepository.findAll().stream().map((c) -> modelMapper.map(c, ToyDto.class)).collect(Collectors.toList());
    }
}
