package com.example.springdatabasicdemo.dtos;

public class ToyDto {
    private int id;
    private String toyTypename;
    private String toyName;
    private String toyDescription;
    private String toyPrice;
    private String toyQuantity;

    public ToyDto(int id, String toyTypename, String toyName, String toyDescription, String toyPrice, String toyQuantity){
        this.id = id;
        this.toyTypename = toyTypename;
        this.toyName = toyName;
        this.toyDescription = toyDescription;
        this.toyPrice = toyPrice;
        this.toyQuantity = toyQuantity;
    }

    public ToyDto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
