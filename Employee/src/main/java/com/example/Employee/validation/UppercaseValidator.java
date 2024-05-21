package com.example.Employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class UppercaseValidator implements ConstraintValidator<Uppercase, String> {
    @Override
    public void initialize(Uppercase constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // value.equals(value.toUpperCase());
        return value != null && Pattern.matches("^[A-Z ]+$", value);
    }
}
