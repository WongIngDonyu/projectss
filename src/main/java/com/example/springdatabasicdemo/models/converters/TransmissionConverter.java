package com.example.springdatabasicdemo.models.converters;

import com.example.springdatabasicdemo.models.Offer;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TransmissionConverter implements AttributeConverter<Offer.Transmission, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Offer.Transmission transmission) {
        return transmission.getNumber();
    }

    @Override
    public Offer.Transmission convertToEntityAttribute(Integer integer) {
        switch (integer){
            case 1:
                return Offer.Transmission.MANUAL;
            case 10:
                return Offer.Transmission.AUTOMATIC;
            default:
                throw new IllegalArgumentException(integer + " not supported");
        }
    }
}
