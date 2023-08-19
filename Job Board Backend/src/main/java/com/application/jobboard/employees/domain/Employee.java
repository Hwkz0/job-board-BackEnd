package com.application.jobboard.employees.domain;

import com.application.jobboard.companies.domain.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Employee {



    @Id
    @GeneratedValue
    private long employeeId;

    private String employeeFirstName;

    private String employeeLastName;

    private String employeeEmailAddress;

    private String employeePassword;

    private String employeePhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    @JsonBackReference(value = "company-employee")
    private Company company;
    private Long companyId;


    protected Employee() {
    }

    public Employee(Long employeeId, String employeeFirstName, String employeeLastName, String employeeEmailAddress, String employeePassword, String employeePhoneNumber) {
        this.employeeId = employeeId;
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
