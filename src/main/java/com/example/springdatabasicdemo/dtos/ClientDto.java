package com.example.springdatabasicdemo.dtos;

import java.util.List;

public class ClientDto {
    private int id;
    private String client_name;
    private String client_phonenumber;
    private String client_email;
    private List<ReviewDto> reviews;
    private List<SaleDto> sales;

    public ClientDto(int id, String client_name, String client_phonenumber, String client_email){
        this.id = id;
        this.client_name = client_name;
        this.client_phonenumber = client_phonenumber;
        this.client_email = client_email;
    }

    public ClientDto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_phonenumber() {
        return client_phonenumber;
    }

    public void setClient_phonenumber(String client_phonenumber) {
        this.client_phonenumber = client_phonenumber;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public List<ReviewDto> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDto> reviews) {
        this.reviews = reviews;
    }

    public List<SaleDto> getSales() {
        return sales;
    }

    public void setSales(List<SaleDto> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Clients { id=" + id + ", Client name=" + client_name + ", Client Phone number=" + client_phonenumber + ", Client email=" + client_email + "}";
    }
}

