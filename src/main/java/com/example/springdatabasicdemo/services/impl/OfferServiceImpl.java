package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.services.dtos.ModelDto;
import com.example.springdatabasicdemo.services.dtos.OfferDto;
import com.example.springdatabasicdemo.services.dtos.UserDto;
import com.example.springdatabasicdemo.models.*;
import com.example.springdatabasicdemo.repositories.ModelRepository;
import com.example.springdatabasicdemo.repositories.OfferRepository;
import com.example.springdatabasicdemo.repositories.UserRepository;
import com.example.springdatabasicdemo.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService<UUID> {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ModelRepository modelRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
    }

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
    public OfferDto add(OfferDto offer, ModelDto modelDto, UserDto userDto) {
        Offer o = modelMapper.map(offer, Offer.class);
        Model model = modelRepository.findById(modelDto.getId()).orElse(null);
        if (model != null) {
            o.setModel(model);
        }
        else {
            throw new NoSuchElementException("Model not found");
        }
        User user = userRepository.findById(userDto.getId()).orElse(null);
        if (user != null) {
            o.setUser(user);
        }
        else {
            throw new NoSuchElementException("User not found");
        }
        o.setCreated(LocalDateTime.now());
        return modelMapper.map(offerRepository.save(o), OfferDto.class);
    }

    @Override
    public  OfferDto update(OfferDto offerDto){
        Optional<Offer> dbOffer = offerRepository.findById(offerDto.getId());
        if (dbOffer.isEmpty()) {
            throw new NoSuchElementException("Offer not found");
        } else {
            Offer offer = dbOffer.get();
            modelMapper.map(offerDto, offer);
            offer.setModified(LocalDateTime.now());
            offer.setCreated(dbOffer.get().getCreated());
            return modelMapper.map(offerRepository.save(offer), OfferDto.class);
        }
    }
}
