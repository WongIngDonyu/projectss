package com.example.springdatabasicdemo.models.enums;

public enum Engine {
    GASOLINE(1), DIESEL(2), ELECTRIC(3), HYBRID(4);
    private int number;
    Engine(int number) {
        this.number=number;
    }
    public int getNumber(){
        return number;
    }
}
