package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.SaleDto;

import java.util.List;

public interface SaleService<I extends Number> {
    SaleDto register(SaleDto sale);

}
