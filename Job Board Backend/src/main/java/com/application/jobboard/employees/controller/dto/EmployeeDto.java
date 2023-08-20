package com.application.jobboard.employees.controller.dto;

import com.application.jobboard.companies.domain.Company;
import com.application.jobboard.employees.domain.Employee;

public class EmployeeDto {

    private Employee employee;
    private Long companyId;
    private Long jobId;


    public EmployeeDto () {

    }

    public EmployeeDto(Employee employee, Long companyId) {
        this.employee = employee;
        this.companyId = companyId;
    }

    public EmployeeDto(Employee employee, Long companyId, Long jobId) {
        this.employee = employee;
        this.companyId = companyId;
        this.jobId = jobId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
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

}
