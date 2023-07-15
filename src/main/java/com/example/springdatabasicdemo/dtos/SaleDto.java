package com.example.springdatabasicdemo.dtos;

import java.time.LocalDate;

public class SaleDto {

    private int id;
    private LocalDate  sale_date;
    private String sale_price;
    private ClientDto client;
    private ToyDto toy;

    public SaleDto(int id, LocalDate sale_date, String sale_price, ClientDto client, ToyDto toy){
        this.id = id;
        this.sale_date = sale_date;
        this.sale_price = sale_price;
        this.client = client;
        this.toy = toy;
    }

    public SaleDto(){}

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

    public ToyDto getToy(){return toy;}

    public void setToy(ToyDto toy){this.toy = toy;}

    @Override
    public String toString() {
        return "Student { id=" + id + ", Sale date=" + sale_date + ", Sale price=" + sale_price + "}";
    }
}
