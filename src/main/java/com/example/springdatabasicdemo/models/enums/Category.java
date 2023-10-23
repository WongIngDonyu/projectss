package com.example.springdatabasicdemo.models.enums;

public enum Category {
    Car(1), Buss(2), Truck(3), Motorcycle(4);

    private int number;
    Category(int number) {
        this.number=number;
    }
    public int getNumber(){
        return number;
    }
}
