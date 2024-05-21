package com.example.Employee.Services;

import com.example.Employee.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(Long id);
    public List<Employee> getAllEmployees();
    public void deleteEmployeeById(Long id);
}
