package com.application.jobboard.employees.domain;

import com.application.jobboard.companies.domain.Company;
import com.application.jobboard.jobs.domain.Job;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private long employeeId;

    @Column(name = "employee_first_name")
    private String employeeFirstName;

    @Column(name = "employee_last_name")
    private String employeeLastName;

    @Column(name = "employee_email_address")
    private String employeeEmailAddress;

    @Column(name = "employee_password")
    private String employeePassword;

    @Column(name = "employee_phone_number")
    private String employeePhoneNumber;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    @JsonBackReference(value = "company-employee")
    private Company company;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "job_id")
    @JsonBackReference(value = "employee-job")
    private List<Job> jobs;


    protected Employee() {
    }

    public Employee(String employeeFirstName, String employeeLastName, String employeeEmailAddress, String employeePassword, String employeePhoneNumber) {

        this.employeeFirstName = employeeFirstName;

        this.employeeLastName = employeeLastName;

        this.employeeEmailAddress = employeeEmailAddress;

        this.employeePassword = employeePassword;

        this.employeePhoneNumber = employeePhoneNumber;

    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeEmailAddress() {
        return employeeEmailAddress;
    }

    public void setEmployeeEmailAddress(String employeeEmailAddress) {
        this.employeeEmailAddress = employeeEmailAddress;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
