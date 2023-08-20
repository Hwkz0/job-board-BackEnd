package com.application.jobboard.jobs.controller.dto;

import com.application.jobboard.applicants.domain.Applicant;
import com.application.jobboard.companies.domain.Company;
import com.application.jobboard.jobs.domain.Job;

public class JobDto {

    private Job job;
    private Long employeeId;
    private Long companyId;
    private Applicant applicant;


    public JobDto() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public JobDto(Job job, String companyId) {
        this.job = job;
        this.companyId = Long.parseLong(companyId);
    }

    public JobDto(Job job, Long companyId, Long employeeId) {
        this.job = job;
        this.companyId = companyId;
        this.employeeId = employeeId;
    }

    public JobDto(Job job,Long companyId, Applicant applicant){
        this.job = job;
        this.companyId = companyId;
        this.applicant = applicant;
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


}
