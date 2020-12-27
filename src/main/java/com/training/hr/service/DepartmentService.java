package com.training.hr.service;

import com.training.hr.entity.Department;
import com.training.hr.exception.ResourceNotFoundException;
import com.training.hr.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;

    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public Department updateDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public void deleteById(int id) {
        departmentRepo.deleteById(id);
    }

    public void deleteByDepartment(Department department) {
        departmentRepo.delete(department);
    }

    public List<Department> findByName(String name) {
        return departmentRepo.findByDepartmentNameContaining(name);
    }

    public Department findById(int id) {
        return departmentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department not found  with id :"+ id));
    }

    public List<Department> getList() {
        return departmentRepo.findAll();
    }
}
