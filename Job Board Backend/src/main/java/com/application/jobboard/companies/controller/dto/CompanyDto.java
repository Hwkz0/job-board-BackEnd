package com.application.jobboard.companies.controller.dto;

import com.application.jobboard.companies.domain.Company;

public class CompanyDto {

    private Company company;
    private Long employeeId;

    public CompanyDto() {

    }

    public CompanyDto(Company company, long employeeId) {
        this.company = company;
        this.employeeId = employeeId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
