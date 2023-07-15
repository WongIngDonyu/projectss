package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reviews")
public class Review extends BaseEntity{
    @Column(name = "review_rating")
    private String review_rating;

    @Column(name = "review_comment")
    private String review_comment;

    @ManyToMany
    @JoinTable(
            name = "client_review",
            joinColumns = @JoinColumn(name = "review_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> client;

    @ManyToMany
    @JoinTable(
            name = "toy_review",
            joinColumns = @JoinColumn(name = "review_id"),
            inverseJoinColumns = @JoinColumn(name = "toy_id")
    )
    private List<Toy> toy;

    public Review(){}

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

    public Review(String review_rating, String review_comment){
        this.review_rating = review_rating;
        this.review_comment = review_comment;
    }
}
