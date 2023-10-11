package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.OfferDto;

import java.util.List;
import java.util.Optional;

public interface OfferService <I extends Number>{
    void delete(OfferDto offer);

    void delete(Integer id);

    List<OfferDto> getAll();

    Optional<OfferDto> findOffer(Integer id);

    OfferDto add(OfferDto offer);
}
