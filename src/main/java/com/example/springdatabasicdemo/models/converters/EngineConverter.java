package com.example.springdatabasicdemo.models.converters;

import com.example.springdatabasicdemo.models.Offer;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EngineConverter implements AttributeConverter<Offer.Engine, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Offer.Engine engine) {
        return engine.getNumber();
    }

    @Override
    public Offer.Engine convertToEntityAttribute(Integer integer) {
        switch (integer){
            case 1:
                return Offer.Engine.GASOLINE;
            case 2:
                return Offer.Engine.DIESEL;
            case 3:
                return Offer.Engine.ELECTRIC;
            case 10:
                return Offer.Engine.HYBRID;
            default:
                throw new IllegalArgumentException(integer + " not supported");
        }
    }
}
