package com.example.Employee.validation;

import com.example.Employee.config.AgeFromNationalIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeFromNationalIdValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAgeFromNationalId {
    String message() default "Invalid age extracted from National ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
