package com.example.springdatabasicdemo.controllers;

public class ClientNotFoundException extends RuntimeException{
    ClientNotFoundException(Integer id) {
        super("Could not find client " + id);
    }
}
