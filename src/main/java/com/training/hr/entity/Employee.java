package com.training.hr.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employees"
        ,catalog="hr"
)
public class Employee implements java.io.Serializable {


    private int employeeId;
    private Department department;
    private Employee employee;
    private Job job;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private Set<Department> departments = new HashSet<Department>(0);
    private Set<Employee> employeeses = new HashSet<Employee>(0);

    public Employee() {
    }


    public Employee(int employeeId, Job job, String lastName, String email, Date hireDate, BigDecimal salary) {
        this.employeeId = employeeId;
        this.job = job;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
    }
    public Employee(int employeeId, Department department, Employee employee, Job job, String firstName, String lastName, String email, String phoneNumber, Date hireDate, BigDecimal salary, BigDecimal commissionPct, Set<Department> departmentses, Set<Employee> employeeses) {
        this.employeeId = employeeId;
        this.department = department;
        this.employee = employee;
        this.job = job;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.departments = departmentses;
        this.employeeses = employeeses;
    }

    @Id

    @
    @Column(name="employee_id", unique=true, nullable=false)
    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id")
    public Department getDepartments() {
        return this.department;
    }

    public void setDepartments(Department department) {
        this.department = department;
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
    @JoinColumn(name="job_id", nullable=false)
    public Job getJobs() {
        return this.job;
    }

    public void setJobs(Job job) {
        this.job = job;
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
    public Set<Department> getDepartmentses() {
        return this.departments;
    }

    public void setDepartmentses(Set<Department> departments) {
        this.departments = departments;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="employees")
    public Set<Employee> getEmployeeses() {
        return this.employeeses;
    }

    public void setEmployeeses(Set<Employee> employeeses) {
        this.employeeses = employeeses;
    }




}
