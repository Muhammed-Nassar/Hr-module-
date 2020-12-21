package com.training.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="departments"
        ,catalog="hr"
)
public class Departments  implements java.io.Serializable {


    private int departmentId;
    private Employees employees;
    private Locations locations;
    private String departmentName;
    private Set<Employees> employeeses = new HashSet<Employees>(0);

    public Departments() {
    }


    public Departments(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
    public Departments(int departmentId, Employees employees, Locations locations, String departmentName, Set<Employees> employeeses) {
        this.departmentId = departmentId;
        this.employees = employees;
        this.locations = locations;
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
    public Employees getEmployees() {
        return this.employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="location_id")
    public Locations getLocations() {
        return this.locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }


    @Column(name="department_name", nullable=false, length=30)
    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="departments")
    public Set<Employees> getEmployeeses() {
        return this.employeeses;
    }

    public void setEmployeeses(Set<Employees> employeeses) {
        this.employeeses = employeeses;
    }




}


