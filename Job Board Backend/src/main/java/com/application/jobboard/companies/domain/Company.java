package com.application.jobboard.companies.domain;


import com.application.jobboard.employees.domain.Employee;
import com.application.jobboard.jobs.domain.Job;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private long companyId;

    private String companyName;

    private String companyEmailAddress;

    private String companyPassword;

    private String companyPhoneNumber;


    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference(value = "company-job")
    private List<Job> jobs;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference(value = "company-employee")
    private List<Employee> employees;

    public Company() {

    }

    public Company(Long companyId, String companyName, String companyEmailAddress, String companyPassword, String companyPhoneNumber) {

        this.companyId = companyId;

        this.companyName = companyName;

        this.companyEmailAddress = companyEmailAddress;

        this.companyPassword = companyPassword;

        this.companyPhoneNumber = companyPhoneNumber;

    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmailAddress() {
        return companyEmailAddress;
    }

    public void setCompanyEmailAddress(String companyEmailAddress) {
        this.companyEmailAddress = companyEmailAddress;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
