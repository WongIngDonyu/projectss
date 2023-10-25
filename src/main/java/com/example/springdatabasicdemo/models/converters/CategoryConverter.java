package com.example.springdatabasicdemo.models.converters;

import com.example.springdatabasicdemo.models.Model;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CategoryConverter implements AttributeConverter<Model.Category, Integer> {


    @Override
    public Integer convertToDatabaseColumn(Model.Category category) {
        return category.getNumber();
    }

    @Override
    public Model.Category convertToEntityAttribute(Integer integer) {
        switch (integer){
            case 1:
                return Model.Category.Car;
            case 2:
                return Model.Category.Buss;
            case 3:
                return Model.Category.Truck;
            case 10:
                return Model.Category.Motorcycle;
            default:
                throw new IllegalArgumentException(integer + " not supported");
        }
    }
}
