package com.training.hr.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="departments"
        ,catalog="hr"
)
public class Department implements java.io.Serializable {


    private int departmentId;
    private Employee employee;
    private Location location;
    private String departmentName;
    private Set<Employee> employeeses = new HashSet<Employee>(0);

    public Department() {
    }


    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
    public Department(int departmentId, Employee employee, Location location, String departmentName, Set<Employee> employeeses) {
        this.departmentId = departmentId;
        this.employee = employee;
        this.location = location;
        this.departmentName = departmentName;
        this.employeeses = employeeses;
    }

    @Id


    @Column(name="department_id", unique=true, nullable=false)
    public int getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="manager_id")
    public Employee getEmployees() {
        return this.employee;
    }

    public void setEmployees(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="location_id")
    public Location getLocations() {
        return this.location;
    }

    public void setLocations(Location location) {
        this.location = location;
    }


    @Column(name="department_name", nullable=false, length=30)
    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="departments")
    public Set<Employee> getEmployeeses() {
        return this.employeeses;
    }

    public void setEmployeeses(Set<Employee> employeeses) {
        this.employeeses = employeeses;
    }




}


