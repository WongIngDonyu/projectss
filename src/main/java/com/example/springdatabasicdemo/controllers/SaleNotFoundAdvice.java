package com.example.springdatabasicdemo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class SaleNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(SaleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String saleNotFoundHandler(SaleNotFoundException ex) {
        return ex.getMessage();
    }
}
