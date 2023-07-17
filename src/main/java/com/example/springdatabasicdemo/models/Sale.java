package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @Column(name = "sale_price")
    private String sale_price;

    @Column(name = "sale_date")
    private LocalDate sale_date;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<ToySale> toySales;

    public Sale() {
    }

    public Sale(String sale_price, LocalDate sale_date, Client client, List<ToySale> toySales) {
        this.sale_price = sale_price;
        this.sale_date = sale_date;
        this.client = client;
        this.toySales = toySales;
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

    public List<ToySale> getToySales() {
        return toySales;
    }

    public void setToySales(List<ToySale> toySales) {
        this.toySales = toySales;
    }
}

