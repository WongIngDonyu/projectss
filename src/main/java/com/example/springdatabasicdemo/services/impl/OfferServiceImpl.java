package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ModelDto;
import com.example.springdatabasicdemo.dtos.OfferDto;
import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.models.Model;
import com.example.springdatabasicdemo.models.Offer;
import com.example.springdatabasicdemo.models.User;
import com.example.springdatabasicdemo.repositories.ModelRepository;
import com.example.springdatabasicdemo.repositories.OfferRepository;
import com.example.springdatabasicdemo.repositories.UserRepository;
import com.example.springdatabasicdemo.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService<Integer> {
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void delete(OfferDto offer) {
        offerRepository.deleteById(offer.getId());
    }

    @Override
    public void delete(UUID id) {
        offerRepository.deleteById(id);
    }

    @Override
    public List<OfferDto> getAll() {
        return offerRepository.findAll().stream().map((m)->modelMapper.map(m, OfferDto.class)).collect(Collectors.toList());

    }

    @Override
    public Optional<OfferDto> findOffer(UUID id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id), OfferDto.class));
    }

    @Override
    public OfferDto add(OfferDto offer) {
        Offer o = modelMapper.map(offer, Offer.class);
        o.setCreated(LocalDateTime.now());
        return modelMapper.map(offerRepository.save(o), OfferDto.class);
    }
}
