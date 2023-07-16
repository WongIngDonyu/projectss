package com.example.springdatabasicdemo.controllers;

public class SaleNotFoundExeption extends RuntimeException{
    SaleNotFoundExeption(Integer id) {
        super("Could not find sale " + id);
    }
}
