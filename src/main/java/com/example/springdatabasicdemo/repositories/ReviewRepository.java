package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Review;
import com.example.springdatabasicdemo.models.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Collection<Review> findAllByClientAndToy(Client client, Toy toy);
}
