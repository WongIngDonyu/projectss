package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ReviewDto;
import com.example.springdatabasicdemo.dtos.SaleDto;

import java.util.List;

public interface ReviewService<I extends Number> {
    ReviewDto register(ReviewDto review);

    List<SaleDto> findReviewByGroup(String client);

    List<ReviewDto> findReviewByGroup(String client, String toy);
}
