package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.SaleDto;

import java.util.List;

public interface SaleService<I extends Number> {
    SaleDto register(SaleDto sale);

    List<SaleDto> findSaleByGroup(String client);

    List<SaleDto> findSaleByGroup(String client, String toy);
}
