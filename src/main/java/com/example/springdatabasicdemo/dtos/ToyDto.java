package com.example.springdatabasicdemo.dtos;

public class ToyDto {
    private int id;
    private String toy_typename;
    private String toy_name;
    private String toy_description;
    private String toy_price;
    private String toy_quantity;

    public ToyDto(int id, String toy_typename, String toy_name, String toy_description, String toy_price, String toy_quantity){
        this.id = id;
        this.toy_typename = toy_typename;
        this.toy_description = toy_description;
        this.toy_price = toy_price;
        this.toy_quantity = toy_quantity;
    }

    public ToyDto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToy_typename() {
        return toy_typename;
    }

    public void setToy_typename(String toy_typename) {
        this.toy_typename = toy_typename;
    }

    public String getToy_name() {
        return toy_name;
    }

    public void setToy_name(String toy_name) {
        this.toy_name = toy_name;
    }

    public String getToy_description() {
        return toy_description;
    }

    public void setToy_description(String toy_description) {
        this.toy_description = toy_description;
    }

    public String getToy_price() {
        return toy_price;
    }

    public void setToy_price(String toy_price) {
        this.toy_price = toy_price;
    }

    public String getToy_quantity() {
        return toy_quantity;
    }

    public void setToy_quantity(String toy_quantity) {
        this.toy_quantity = toy_quantity;
    }

    @Override
    public String toString() {
        return "Clients { id=" + id + ", Client name=" + toy_typename + ", Client Phone number=" + toy_name + ", Client email=" + toy_description + ", Toy price=" + toy_price + ", Toy quantity=" + toy_quantity + "}";
    }
}
