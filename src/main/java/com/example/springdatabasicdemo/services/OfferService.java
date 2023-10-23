package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.OfferDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferService <I extends Number>{
    void delete(OfferDto offer);

    void delete(UUID id);

    List<OfferDto> getAll();

    Optional<OfferDto> findOffer(UUID id);

    OfferDto add(OfferDto offer);
}
