package com.example.springdatabasicdemo.dtos;

public class ReviewDto {
    private int id;
    private String review_rating;
    private String review_comment;
    private ClientDto client;
    private ToyDto toy;

    public ReviewDto(int id, String review_rating, String review_comment, ClientDto client, ToyDto toy){
        this.id = id;
        this.review_rating = review_rating;
        this.review_comment = review_comment;
        this.client = client;
        this.toy = toy;
    }

    public ReviewDto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview_rating() {
        return review_rating;
    }

    public void setReview_rating(String review_rating) {
        this.review_rating = review_rating;
    }

    public String getReview_comment() {
        return review_comment;
    }

    public void setReview_comment(String review_comment) {
        this.review_comment = review_comment;
    }

    public ClientDto getClient(){return client;}

    public void setClient(ClientDto client){this.client = client;}

    public ToyDto getToy(){return toy;}

    public void setToy(ToyDto toy){this.toy = toy;}

    @Override
    public String toString() {
        return "Student { id=" + id + ", Sale date=" + review_rating + ", Sale price=" + review_comment + "}";
    }
}
