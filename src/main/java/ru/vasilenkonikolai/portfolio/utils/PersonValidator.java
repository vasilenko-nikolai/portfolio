package ru.vasilenkonikolai.portfolio.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.vasilenkonikolai.portfolio.models.Person;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
