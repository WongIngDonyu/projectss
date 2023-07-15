package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @Column(name = "sale_price")
    private String sale_price;

    @Column(name = "sale_date")
    private String sale_date;

    @ManyToMany
    @JoinTable(
            name = "client_sale",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> client;

    @ManyToMany
    @JoinTable(
            name = "toy_sale",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "toy_id")
    )
    private List<Toy> toy;

    public Sale() {
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public String getSale_date() {
        return sale_date;
    }

    public void setSale_date(String sale_date) {
        this.sale_date = sale_date;
    }

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    public List<Toy> getToy() {
        return toy;
    }

    public void setToy(List<Toy> toy) {
        this.toy = toy;
    }

    public Sale(String sale_date, String sale_price){
        this.sale_date = sale_date;
        this.sale_price = sale_price;
    }
}

