package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.ReviewDto;
import com.example.springdatabasicdemo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    Iterable<ReviewDto> all() {
        return reviewService.getAll();
    }

    @PostMapping("/review")
    ReviewDto newReview(@RequestBody ReviewDto newReview)
    {  return reviewService.register(newReview); }

    @GetMapping("/review/{id}")
    ReviewDto one(@PathVariable Integer id) throws Throwable {
        return (ReviewDto) reviewService.findReview(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }

    @DeleteMapping("/review/{id}")
    void deleteStudent(@PathVariable Integer id) {
        reviewService.expel(id);

    }
    @GetMapping("/reviews/{reviewId}/toyName")
    public String getToyNameByReviewId(@PathVariable Long reviewId) {
        String toyName = reviewService.findToyNameByReviewId(reviewId);
        if (toyName == null) {
            throw new ReviewNotFoundException(Math.toIntExact(reviewId));
        }
        return toyName;
    }
}
