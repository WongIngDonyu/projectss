package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Sale;
import com.example.springdatabasicdemo.models.Toy;

public class ToySaleDto {
    private int id;
    private Sale sale;
    private Toy toy;

    public ToySaleDto(int id, Sale sale, Toy toy) {
        this.id = id;
        this.sale = sale;
        this.toy = toy;
    }

    public ToySaleDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }
}
