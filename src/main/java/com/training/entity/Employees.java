package com.training.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employees"
        ,catalog="hr"
)
public class Employees  implements java.io.Serializable {


    private int employeeId;
    private Departments departments;
    private Employees employees;
    private Jobs jobs;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private Set<Departments> departmentses = new HashSet<Departments>(0);
    private Set<Employees> employeeses = new HashSet<Employees>(0);

    public Employees() {
    }


    public Employees(int employeeId, Jobs jobs, String lastName, String email, Date hireDate, BigDecimal salary) {
        this.employeeId = employeeId;
        this.jobs = jobs;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
    }
    public Employees(int employeeId, Departments departments, Employees employees, Jobs jobs, String firstName, String lastName, String email, String phoneNumber, Date hireDate, BigDecimal salary, BigDecimal commissionPct, Set<Departments> departmentses, Set<Employees> employeeses) {
        this.employeeId = employeeId;
        this.departments = departments;
        this.employees = employees;
        this.jobs = jobs;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.departmentses = departmentses;
        this.employeeses = employeeses;
    }

    @Id


    @Column(name="employee_id", unique=true, nullable=false)
    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id")
    public Departments getDepartments() {
        return this.departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
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
    @JoinColumn(name="job_id", nullable=false)
    public Jobs getJobs() {
        return this.jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }


    @Column(name="first_name", length=20)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Column(name="last_name", nullable=false, length=25)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Column(name="email", nullable=false, length=25)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name="phone_number", length=20)
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="hire_date", nullable=false, length=10)
    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }


    @Column(name="salary", nullable=false, precision=8)
    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }


    @Column(name="commission_pct", precision=2)
    public BigDecimal getCommissionPct() {
        return this.commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="employees")
    public Set<Departments> getDepartmentses() {
        return this.departmentses;
    }

    public void setDepartmentses(Set<Departments> departmentses) {
        this.departmentses = departmentses;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="employees")
    public Set<Employees> getEmployeeses() {
        return this.employeeses;
    }

    public void setEmployeeses(Set<Employees> employeeses) {
        this.employeeses = employeeses;
    }




}
