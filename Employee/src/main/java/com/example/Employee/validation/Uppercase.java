package com.example.Employee.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UppercaseValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Uppercase {
    String message() default "{name.uppercase}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
