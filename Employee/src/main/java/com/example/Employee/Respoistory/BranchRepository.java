package com.example.Employee.Respoistory;

import com.example.Employee.Entity.Branch;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class BranchRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveBranch(Branch branch) {
        getCurrentSession().save(branch);
    }

    public Branch getBranchById(Long id) {
        return getCurrentSession().get(Branch.class, id);
    }

    public List<Branch> getAllBranches() {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Branch> criteria = builder.createQuery(Branch.class);
        Root<Branch> root = criteria.from(Branch.class);
        criteria.select(root);
        return getCurrentSession().createQuery(criteria).getResultList();
    }

    public void updateBranch(Branch branch) {
        getCurrentSession().update(branch);
    }

    public void deleteBranch(Branch branch) {
        getCurrentSession().delete(branch);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
