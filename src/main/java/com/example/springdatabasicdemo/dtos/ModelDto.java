package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Brand;
import com.example.springdatabasicdemo.models.Offer;
import com.example.springdatabasicdemo.models.enums.Category;
import jakarta.persistence.*;

import java.util.List;

public class ModelDto {
    private String name;
    private Category category;
    private String imageUrl;
    private int startYear;
    private int endYear;
    private BrandDto brand;
    public ModelDto(){}
    public ModelDto(String name, Category category, String imageUrl, int startYear, int endYear, BrandDto brand) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brand = brand;
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

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }
}
