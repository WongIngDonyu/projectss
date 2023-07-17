package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity {

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_phonenumber")
    private String clientPhoneNumber;

    @Column(name = "client_email")
    private String clientEmail;
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Sale> sales;

    public Client() {
    }

    public Client(String clientName, String clientPhoneNumber, String clientEmail, List<Review> reviews, List<Sale> sales) {
        this.clientName = clientName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmail = clientEmail;
        this.reviews = reviews;
        this.sales = sales;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}