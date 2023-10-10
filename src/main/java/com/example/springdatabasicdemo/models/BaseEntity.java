package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;
    @Column(name = "created")
    protected LocalDateTime created;
    @Column(name = "modified")
    protected LocalDateTime modified;

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

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }
}
