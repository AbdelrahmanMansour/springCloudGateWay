package com.example.Employee.Services;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Respoistory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private  EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
         employeeRepository.saveEmployee(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.getEmployeeById(id);

    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        if(employee != null){
            employeeRepository.deleteEmployee(employee);
        }
    }

}
