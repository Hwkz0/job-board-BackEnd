package com.application.jobboard.jobs.domain;


import com.application.jobboard.applicants.domain.Applicant;
import com.application.jobboard.companies.domain.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue
    private long jobId;

    private String jobTitle;

    private String jobLocation;

    private String jobType;

    private String jobSalary;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    @JsonBackReference(value = "company-job")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "applicantId")
    @JsonBackReference(value = "applicant-job")
    private List<Applicant> applicants;


    public Job() {

    }

    public Job(Long jobId, String jobTitle, String jobLocation, String jobType, String jobSalary) {

        this.jobId = jobId;

        this.jobTitle = jobTitle;

        this.jobLocation = jobLocation;

        this.jobType = jobType;

        this.jobSalary = jobSalary;

    }


    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }
}
