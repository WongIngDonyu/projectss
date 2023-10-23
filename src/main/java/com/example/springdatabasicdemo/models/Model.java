package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.models.enums.Category;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{
    @Column(name = "modelName")
    private String name;
    @Column(name = "category")
    private Category category;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "startYear")
    private int startYear;
    @Column(name = "endYear")
    private int endYear;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @OneToMany(mappedBy = "model", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Offer> offers;
    public Model(){}

    public Model(String name, Category category, String imageUrl, int startYear, int endYear, Brand brand, List<Offer> offers) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
        this.offers = offers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
