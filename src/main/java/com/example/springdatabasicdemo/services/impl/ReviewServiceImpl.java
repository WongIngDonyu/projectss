package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ReviewDto;
import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Review;
import com.example.springdatabasicdemo.models.Toy;
import com.example.springdatabasicdemo.repositories.ClientRepository;
import com.example.springdatabasicdemo.repositories.ReviewRepository;
import com.example.springdatabasicdemo.repositories.ToyRepository;
import com.example.springdatabasicdemo.services.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService<Integer> {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ReviewDto register(ReviewDto review) {
        Review r = modelMapper.map(review, Review.class);
        if (review.getClient().getId() != 0) {
            Client c = clientRepository.findById(review.getClient().getId()).get();
            r.setClient((List<Client>) c);
        }
        if (review.getToy().getId() != 0) {
            Toy t = toyRepository.findById(review.getToy().getId()).get();
            r.setToy((List<Toy>) t);
        }
        return modelMapper.map(reviewRepository.save(r), ReviewDto.class);
    }

    @Override
    public List<SaleDto> findReviewByGroup(String client) {
        return null;
    }
    @Override
    public List<ReviewDto> findReviewByGroup(String client, String toy) {
        Client clientObject = clientRepository.findByClientName(client);
        Toy toyObject = toyRepository.findByToyName(toy);
        return reviewRepository.findAllByClientAndToy(clientObject, toyObject)
                .stream()
                .map(r -> modelMapper.map(r, ReviewDto.class))
                .collect(Collectors.toList());
    }
}
