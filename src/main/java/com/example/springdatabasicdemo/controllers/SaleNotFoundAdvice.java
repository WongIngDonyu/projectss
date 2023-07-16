package com.example.springdatabasicdemo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class SaleNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(SaleNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String saleNotFoundHandler(SaleNotFoundExeption ex) {
        return ex.getMessage();
    }
}
