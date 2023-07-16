package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Review;
import com.example.springdatabasicdemo.models.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r.toy.toyName from Review r where r.id = :reviewId")
    String findToyNameByReviewId(Long reviewId);
}
