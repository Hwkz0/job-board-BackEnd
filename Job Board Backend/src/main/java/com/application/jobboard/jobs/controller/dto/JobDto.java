package com.application.jobboard.jobs.controller.dto;

import com.application.jobboard.companies.domain.Company;
import com.application.jobboard.jobs.domain.Job;

public class JobDto {

    private Job job;

    private Long companyId;

    private Company company;

    public JobDto() {
    }

    public void setJob(Job job,Long companyId) {
        this.job = job;
        this.companyId = companyId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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
