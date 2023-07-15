package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reviews")
public class Review extends BaseEntity{
    @Column(name = "review_rating")
    private int review_rating;

    @Column(name = "review_comment")
    private String review_comment;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "toy_id")
    private Toy toy;

    public Review(){}

    public Review(int review_rating, String review_comment, Client client, Toy toy) {
        this.review_rating = review_rating;
        this.review_comment = review_comment;
        this.client = client;
        this.toy = toy;
    }

    public int getReview_rating() {
        return review_rating;
    }

    public void setReview_rating(int review_rating) {
        this.review_rating = review_rating;
    }

    public String getReview_comment() {
        return review_comment;
    }

    public void setReview_comment(String review_comment) {
        this.review_comment = review_comment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }
}
