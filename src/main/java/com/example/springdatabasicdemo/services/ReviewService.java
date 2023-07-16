package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ReviewDto;
import com.example.springdatabasicdemo.dtos.SaleDto;

import java.util.List;
import java.util.Optional;

public interface ReviewService<I extends Number> {
    ReviewDto register(ReviewDto review);

    void expel(ReviewDto review);

    void expel(Integer id);

    List<ReviewDto> getAll();

    Optional<SaleDto> findReview(Integer id);
    String findToyNameByReviewId(Long reviewId);
}
