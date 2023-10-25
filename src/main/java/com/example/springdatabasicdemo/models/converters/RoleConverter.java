package com.example.springdatabasicdemo.models.converters;

import com.example.springdatabasicdemo.models.UserRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class RoleConverter implements AttributeConverter<UserRole.Role, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserRole.Role role) {
        return role.getNumber();
    }

    @Override
    public UserRole.Role convertToEntityAttribute(Integer integer) {
        switch (integer){
            case 1:
                return UserRole.Role.User;
            case 10:
                return UserRole.Role.Admin;
            default:
                throw new IllegalArgumentException(integer + " not supported");
        }
    }
}
