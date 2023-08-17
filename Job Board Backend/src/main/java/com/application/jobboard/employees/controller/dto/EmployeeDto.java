package com.application.jobboard.employees.controller.dto;

import com.application.jobboard.companies.domain.Company;
import com.application.jobboard.employees.domain.Employee;

public class EmployeeDto {

    private Employee employee;
    private Long companyId;
    private Company company;

    public EmployeeDto () {

    }

    public EmployeeDto(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDto(Employee employee, Long companyId, Company company) {
        this.employee = employee;
        this.companyId = companyId;
        this.company = company;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
