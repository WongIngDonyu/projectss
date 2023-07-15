package com.example.springdatabasicdemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.intellij.lang.annotations.Pattern;

@Entity
@Table(name = "toys")
public class Toy extends BaseEntity {
    private final static String type = "TOY";

    @Column(name = "toy_typename")
    private String toyTypename;

    @Column(name = "toy_name")
    private String toyName;

    @Column(name = "toy_description")
    private String toyDescription;

    @Column(name = "toy_price")
    private String toyPrice;

    @Column(name = "toy_quantity")
    private String toyQuantity;

    public Toy() {}

    public Toy(String toyTypename, String toyName, String toyDescription, String toyPrice, String toyQuantity) {
        this.toyTypename = toyTypename;
        this.toyName = toyName;
        this.toyDescription = toyDescription;
        this.toyPrice = toyPrice;
        this.toyQuantity = toyQuantity;
    }

    public String getToyTypename() {
        return toyTypename;
    }

    public void setToyTypename(String toyTypename) {
        this.toyTypename = toyTypename;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public String getToyDescription() {
        return toyDescription;
    }

    public void setToyDescription(String toyDescription) {
        this.toyDescription = toyDescription;
    }

    public String getToyPrice() {
        return toyPrice;
    }

    public void setToyPrice(String toyPrice) {
        this.toyPrice = toyPrice;
    }

    public String getToyQuantity() {
        return toyQuantity;
    }

    public void setToyQuantity(String toyQuantity) {
        this.toyQuantity = toyQuantity;
    }
}
