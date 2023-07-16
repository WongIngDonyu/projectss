package com.example.springdatabasicdemo.dtos;

import java.time.LocalDate;
import java.util.List;

public class SaleDto {

    private int id;
    private LocalDate  sale_date;
    private String sale_price;
    private ClientDto client;
    private List<ToyDto> toys;
    public SaleDto(){}

    public SaleDto(int id, LocalDate sale_date, String sale_price, ClientDto client, List<ToyDto> toys) {
        this.id = id;
        this.sale_date = sale_date;
        this.sale_price = sale_price;
        this.client = client;
        this.toys = toys;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate  getSale_date() {
        return sale_date;
    }

    public void setSale_date(LocalDate  sale_data) {
        this.sale_date = sale_data;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public ClientDto getClient(){return client;}

    public void setClient(ClientDto client){this.client = client;}

    public List<ToyDto> getToys() {
        return toys;
    }

    public void setToys(List<ToyDto> toys) {
        this.toys = toys;
    }
}
