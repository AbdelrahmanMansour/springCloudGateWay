package com.example.Employee.Entity;

import com.example.Employee.validation.UniqueNationalId;
import com.example.Employee.validation.Uppercase;
import com.example.Employee.validation.ValidAgeFromNationalId;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.time.LocalDate;


@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "{NotEmpty.employee.nationalId}")
    @Size(min = 14, max = 14, message = "{Size.employee.nationalId}")
    @UniqueNationalId(message = "{UniqueNationalId.employee.nationalId}")
    @ValidAgeFromNationalId(message = "{ValidAgeFromNationalId.employee.nationalId}")
    private String nationalId;

    @Column(nullable = false)
    @NotEmpty(message = "{NotEmpty.employee.name}")
    @Pattern(regexp = "^[A-Za-z]+$", message = "{Pattern.employee.name}")
    @Uppercase(message = "{Uppercase.employee.name}")
    private String name;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

}

