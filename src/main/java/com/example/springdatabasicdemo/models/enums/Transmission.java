package com.example.springdatabasicdemo.models.enums;

public enum Transmission {
    MANUAL(1), AUTOMATIC(2);
    private int number;
    Transmission(int number) {
        this.number=number;
    }
    public int getNumber(){
        return number;
    }
}
