package com.example.springdatabasicdemo.controllers;

public class ToyNotFoundException extends RuntimeException{
    ToyNotFoundException(Integer id) {
        super("Could not find toy " + id);
    }
}
