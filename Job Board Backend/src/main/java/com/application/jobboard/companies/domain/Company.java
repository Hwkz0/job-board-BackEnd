package com.application.jobboard.companies.domain;


import com.application.jobboard.employees.domain.Employee;
import com.application.jobboard.jobs.domain.Job;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private long companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_email_address")
    private String companyEmailAddress;

    @Column(name = "company_password")
    private String companyPassword;

    @Column(name = "company_phone_number")
    private String companyPhoneNumber;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference(value = "company-job")
    private List<Job> jobs;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference(value = "company-employee")
    private List<Employee> employees;

    public Company() {

    }

    public Company(String companyName, String companyEmailAddress, String companyPassword, String companyPhoneNumber) {

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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
