package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Sale;
import com.example.springdatabasicdemo.models.Toy;

public class ToySaleDto {
    private Long id;
    private SaleDto sale;
    private ToyDto toy;

    public ToySaleDto() {
    }

    public ToySaleDto(Long id, SaleDto sale, ToyDto toy) {
        this.id = id;
        this.sale = sale;
        this.toy = toy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SaleDto getSale() {
        return sale;
    }

    public void setSale(SaleDto sale) {
        this.sale = sale;
    }

    public ToyDto getToy() {
        return toy;
    }

    public void setToy(ToyDto toy) {
        this.toy = toy;
    }
}
