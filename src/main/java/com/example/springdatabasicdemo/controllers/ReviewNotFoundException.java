package com.example.springdatabasicdemo.controllers;

import java.time.LocalDate;

public class ReviewNotFoundException extends RuntimeException {
    ReviewNotFoundException(Integer id) {
        super("Could not find review " + id);
    }
}
