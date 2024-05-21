package com.example.Employee.config;

import com.example.Employee.validation.ValidAgeFromNationalId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AgeFromNationalIdValidator implements ConstraintValidator<ValidAgeFromNationalId, String> {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");

    @Override
    public boolean isValid(String nationalId, ConstraintValidatorContext context) {
        if (nationalId == null || nationalId.length() != 14) {
            return false;
        }
        try {
            String birthDateString = nationalId.substring(1, 6);
            LocalDate birthDate = LocalDate.parse(birthDateString, DATE_FORMATTER);
            int currentYear = LocalDate.now().getYear() % 100;
            int birthYear = birthDate.getYear();
            if (birthYear > currentYear) {
                birthDate = birthDate.minusYears(100);
            }
            int age = Period.between(birthDate, LocalDate.now()).getYears();
            return age >= 18 && age <= 99; // Assuming valid age range is 18 to 99
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}

