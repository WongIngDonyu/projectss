package com.example.springdatabasicdemo.models.enums;

public enum Role {
    User(1), Admin(2);
    private int number;
    Role(int number) {
        this.number=number;
    }
    public int getNumber(){
        return number;
    }
}
