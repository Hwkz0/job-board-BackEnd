package com.application.jobboard.candidates.controller.dto;

import com.application.jobboard.applicants.domain.Applicant;
import com.application.jobboard.candidates.domain.Candidate;
import com.application.jobboard.companies.domain.Company;

public class CandidateDto {

    private Candidate candidate;
    private long jobId;
    private Company company;
    private long companyId;


    public CandidateDto() {

    }


    public CandidateDto(Candidate candidate, long jobId){
        this.candidate = candidate;
        this.jobId = jobId;
    }

    public CandidateDto(Candidate candidate, long jobId, Company company){
        this.candidate = candidate;
        this.jobId = jobId;
        this.company = company;
    }


    public CandidateDto(Candidate candidate, Company company, long companyId, long jobId){
        this.candidate = candidate;
        this.company = company;
        this.companyId = companyId;
        this.jobId = jobId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
}