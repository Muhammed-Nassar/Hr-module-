package com.training.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="jobs"
        ,catalog="hr"
)
public class Jobs  implements java.io.Serializable {


    private String jobId;
    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;
    private Set<Employees> employeeses = new HashSet<Employees>(0);

    public Jobs() {
    }


    public Jobs(String jobId, String jobTitle) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
    }
    public Jobs(String jobId, String jobTitle, Integer minSalary, Integer maxSalary, Set<Employees> employeeses) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.employeeses = employeeses;
    }

    @Id


    @Column(name="job_id", unique=true, nullable=false, length=10)
    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }


    @Column(name="job_title", nullable=false, length=35)
    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


    @Column(name="min_salary", precision=8, scale=0)
    public Integer getMinSalary() {
        return this.minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }


    @Column(name="max_salary", precision=8, scale=0)
    public Integer getMaxSalary() {
        return this.maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="jobs")
    public Set<Employees> getEmployeeses() {
        return this.employeeses;
    }

    public void setEmployeeses(Set<Employees> employeeses) {
        this.employeeses = employeeses;
    }




}


