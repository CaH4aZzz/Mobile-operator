package com.example.mobileoperator.converter;

import com.example.mobileoperator.model.Gender;

import javax.persistence.AttributeConverter;

public class GenderConverter implements AttributeConverter<Gender, Character> {

    @Override
    public Character convertToDatabaseColumn(Gender gender) {
        if(gender == null){
            return null;
        }
        return gender.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Character code) {
        if(code == null){
            return null;
        }
        return Gender.fromCode(code);
    }
}
