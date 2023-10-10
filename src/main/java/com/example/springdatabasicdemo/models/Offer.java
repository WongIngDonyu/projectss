package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.models.enums.Engine;
import com.example.springdatabasicdemo.models.enums.Transmission;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    @Column(name = "description")
    private String description ;
    @Column(name = "engine")
    private Engine engine ;
    @Column(name = "imageUrl")
    private String imageUrl  ;
    @Column(name = "mileage")
    private int mileage  ;
    @Column(name = "price")
    private int price ;
    @Column(name = "transmission")
    private Transmission transmission  ;
    @Column(name = "year")
    private int year;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;//связь
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private User user;//связь

    public Offer(){}
    public Offer(String description, Engine engine, String imageUrl, int mileage, int price, Transmission transmission, int year, Model model, User user) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
