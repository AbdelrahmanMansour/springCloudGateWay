package com.example.Employee.Respoistory;

import com.example.Employee.Entity.Employee;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public void saveEmployee(Employee employee) {
            getCurrentSession().save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return getCurrentSession().get(Employee.class, id);
    }

    public Employee getEmployeeByNationalId(String nationalId) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(root).where(builder.equal(root.get("nationalId"), nationalId));
        Query<Employee> query = getCurrentSession().createQuery(criteria);
        return query.uniqueResult();
    }
    public List<Employee> getAllEmployees() {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(root);
        return getCurrentSession().createQuery(criteria).getResultList();
    }

    public void updateEmployee(Employee employee) {
        getCurrentSession().update(employee);
    }

    public void deleteEmployee(Employee employee) {
        getCurrentSession().delete(employee);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
