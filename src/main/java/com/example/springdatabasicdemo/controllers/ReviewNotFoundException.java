package com.example.springdatabasicdemo.controllers;

public class ReviewNotFoundException extends RuntimeException {
    ReviewNotFoundException(Integer id) {
        super("Could not find review " + id);
    }
}
