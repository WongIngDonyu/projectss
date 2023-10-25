package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ModelDto {
    private UUID id;
    private String name;
    private Model.Category category;
    private String imageUrl;
    private int startYear;
    private int endYear;
    private LocalDateTime created;
    private LocalDateTime modified;
    public ModelDto(){}

    public ModelDto(UUID id, String name, Model.Category category, String imageUrl, int startYear, int endYear, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Model.Category getCategory() {
        return category;
    }

    public void setCategory(Model.Category category) {
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
