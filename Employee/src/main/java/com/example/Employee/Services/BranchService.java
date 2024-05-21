package com.example.Employee.Services;

import com.example.Employee.Entity.Branch;
import com.example.Employee.Respoistory.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllBranches() {
        return branchRepository.getAllBranches();
    }

    public Branch getBranchById(Long id) {
        return branchRepository.getBranchById(id);
    }

    public void createBranch(Branch branch) {
         branchRepository.saveBranch(branch);
    }

    public void updateBranch(Long id, Branch branchDetails) {
        Branch branch = branchRepository.getBranchById(id);
        branch.setName(branchDetails.getName());
        branchRepository.saveBranch(branch);
    }

    public void deleteBranch(Long id) {
        Branch branch = branchRepository.getBranchById(id);
        branchRepository.deleteBranch(branch);
    }
}
