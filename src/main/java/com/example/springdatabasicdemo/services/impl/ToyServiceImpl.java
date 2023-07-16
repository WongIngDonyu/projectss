package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ToyDto;
import com.example.springdatabasicdemo.models.Toy;
import com.example.springdatabasicdemo.repositories.ClientRepository;
import com.example.springdatabasicdemo.repositories.ReviewRepository;
import com.example.springdatabasicdemo.repositories.ToyRepository;
import com.example.springdatabasicdemo.services.ToyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
