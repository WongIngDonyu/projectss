package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ModelDto;
import com.example.springdatabasicdemo.dtos.OfferDto;
import com.example.springdatabasicdemo.dtos.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferService <I extends UUID>{
    void delete(OfferDto offer);

    void delete(UUID id);

    List<OfferDto> getAll();

    Optional<OfferDto> findOffer(UUID id);

    OfferDto add(OfferDto offer, ModelDto modelDto, UserDto userDto);
    OfferDto update(OfferDto offerDto);
}
