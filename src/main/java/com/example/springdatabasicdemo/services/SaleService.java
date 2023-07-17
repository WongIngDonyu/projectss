package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ClientDto;
import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.dtos.ToyDto;
import com.example.springdatabasicdemo.models.Client;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SaleService<I extends Number> {
    SaleDto register(SaleDto sale);

    void expel(Integer id);

    void expel(SaleDto sale);

    List<SaleDto> getAll();

    Optional<SaleDto> findSale(Integer id);
    List<String> findClientsBySaleDate(LocalDate date);
   /* List<String> findToyNamesBySaleId(Long saleId);*/
}
