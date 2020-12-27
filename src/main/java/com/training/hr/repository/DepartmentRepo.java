package com.training.hr.repository;

import com.training.hr.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    public List<Department> findByDepartmentNameContaining(String name);
}
