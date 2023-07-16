package com.example.springdatabasicdemo.controllers;

import java.time.LocalDate;

public class SaleNotFoundException extends RuntimeException {
    public SaleNotFoundException(Integer id) {
        super("Could not find sale " + id);
    }

    public SaleNotFoundException(LocalDate date) {
        super("Could not find sale date " + date);
    }
}

