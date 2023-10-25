package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Offer;

import java.time.LocalDateTime;
import java.util.UUID;

public class OfferDto {
    private UUID id;
    private String description;
    private Offer.Engine engine;
    private String imageUrl;
    private int mileage;
    private int price;
    private Offer.Transmission transmission;
    private int year;
    private LocalDateTime created;
    private LocalDateTime modified;
    public OfferDto(){}

    public OfferDto(UUID id, String description, Offer.Engine engine, String imageUrl, int mileage, int price, Offer.Transmission transmission, int year, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Offer.Engine getEngine() {
        return engine;
    }

    public void setEngine(Offer.Engine engine) {
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

    public Offer.Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Offer.Transmission transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
