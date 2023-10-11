package com.example.fundyassignment.repository.converter;

import com.example.fundyassignment.common.UserAuthority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter
public class UserAuthorityConverter implements AttributeConverter<UserAuthority, String> {
    @Override
    public String convertToDatabaseColumn(UserAuthority attribute) {
        if(attribute.equals(UserAuthority.NORMAL)) {
            return "N";
        }

        if(attribute.equals(UserAuthority.CREATOR)) {
            return "C";
        }

        return null;
    }

    @Override
    public UserAuthority convertToEntityAttribute(String dbData) {
        if(dbData.equals("N")) {
            return UserAuthority.NORMAL;
        }

        if(dbData.equals("C")) {
            return UserAuthority.CREATOR;
        }

        return null;
    }
}
