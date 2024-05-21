package com.example.Employee.Respoistory;

import com.example.Employee.Entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository {
     void saveEmployee(Employee employee);
     Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    Employee getEmployeeByNationalId(String nationalId);
}
