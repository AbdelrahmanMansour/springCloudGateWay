package com.example.Employee.validation;


import com.example.Employee.Entity.Employee;
import com.example.Employee.Respoistory.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;



public class NationalIdValidator implements ConstraintValidator<UniqueNationalId , String> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void initialize(UniqueNationalId  constraintAnnotation) {
    }

    @Override
    public boolean isValid(String nationalId, ConstraintValidatorContext context) {
         Employee employee = employeeRepository.getEmployeeByNationalId(nationalId);
         return  employee == null;
    }
}

