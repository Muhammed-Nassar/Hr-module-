package com.training.service;

import com.training.entity.Departments;
import com.training.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;

    public void addNew(Departments department) {
        departmentRepo.save(department);
    }

    public List<Departments> getList() {
        return departmentRepo.findAll();
    }

    public void deleteById(int id ){
        departmentRepo.deleteById(id);
    }
}
