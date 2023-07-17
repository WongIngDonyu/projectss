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
import java.util.Optional;
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
            r.setClient(c);
        }
        if (review.getToy().getId() != 0) {
            Toy t = toyRepository.findById(review.getToy().getId()).get();
            r.setToy(t);
        }
        return modelMapper.map(reviewRepository.save(r), ReviewDto.class);
    }

    @Override
    public void delete(Integer id) {
        reviewRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void delete(ReviewDto review) {
        reviewRepository.deleteById((long) review.getId());
    }

    @Override
    public List<ReviewDto> getAll() {
        return reviewRepository.findAll().stream().map((r) -> modelMapper.map(r, ReviewDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<SaleDto> findReview(Integer id) {
        return Optional.empty();
    }

    @Override
    public String findToyNameByReviewId(Long reviewId) {
        return reviewRepository.findToyNameByReviewId(reviewId);
    }
}
