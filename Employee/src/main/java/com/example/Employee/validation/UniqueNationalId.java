package com.example.Employee.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NationalIdValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueNationalId  {
    String message() default "{nationalId.length}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
