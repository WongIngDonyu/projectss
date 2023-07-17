package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ClientDto;
import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.dtos.ToyDto;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Sale;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SaleService<I extends Number> {
    SaleDto register(SaleDto sale);

    void delete(Integer id);

    void delete(SaleDto sale);

    List<SaleDto> getAll();

    Optional<SaleDto> findSale(Integer id);
    List<String> findClientsBySaleDate(LocalDate date);
    List<Long> findSaleIdsByAmountAndToyId(String sale_price, Long toyId);
}
