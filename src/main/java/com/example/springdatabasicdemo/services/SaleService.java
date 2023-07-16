package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ClientDto;
import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.dtos.ToyDto;

import java.util.List;
import java.util.Optional;

public interface SaleService<I extends Number> {
    SaleDto register(SaleDto sale);

    void expel(Integer id);

    void expel(SaleDto sale);

    List<SaleDto> getAll();

    List<SaleDto> findSales(String client, String toy);

    Optional<SaleDto> findSale(Integer id);
}
