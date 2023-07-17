package com.example.springdatabasicdemo.dtos;

import java.time.LocalDate;
import java.util.List;

public class SaleShortDto {

    private Long id;
    private String sale_price;
    private LocalDate sale_date;
    private ClientDto client;
    public SaleShortDto(){}

    public SaleShortDto(Long id, String sale_price, LocalDate sale_date, ClientDto client) {
        this.id = id;
        this.sale_price = sale_price;
        this.sale_date = sale_date;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public LocalDate getSale_date() {
        return sale_date;
    }

    public void setSale_date(LocalDate sale_date) {
        this.sale_date = sale_date;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }
}
