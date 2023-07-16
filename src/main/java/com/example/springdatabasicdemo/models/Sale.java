package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @Column(name = "sale_price")
    private String sale_price;

    @Column(name = "sale_date")
    private LocalDate sale_date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "toy_sale",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "toy_id")
    )
    private List<Toy> toys;

    public Sale() {
    }

    public Sale(String sale_price, LocalDate sale_date, Client client, List<Toy> toys) {
        this.sale_price = sale_price;
        this.sale_date = sale_date;
        this.client = client;
        this.toys = toys;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }
}
