package com.application.jobboard.jobs.domain;


import com.application.jobboard.applicants.domain.Applicant;
import com.application.jobboard.companies.domain.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue
    private long jobId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "job_salary")
    private String jobSalary;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    @JsonBackReference(value = "company-job")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    @JsonBackReference(value = "employee-job")
    private Company employee;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_id")
    @JsonManagedReference(value = "applicant-job")
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
