package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.OfferDto;
import com.example.springdatabasicdemo.repositories.OfferRepository;
import com.example.springdatabasicdemo.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OfferServiceImpl implements OfferService<Integer> {
    @Autowired
    private OfferRepository offerRepository;

    @Override
    public void delete(OfferDto offer) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<OfferDto> getAll() {
        return null;
    }

    @Override
    public Optional<OfferDto> findOffer(Integer id) {
        return Optional.empty();
    }

    @Override
    public OfferDto add(OfferDto offer) {
        return null;
    }
}
