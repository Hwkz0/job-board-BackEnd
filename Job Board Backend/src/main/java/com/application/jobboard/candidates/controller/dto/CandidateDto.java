package com.application.jobboard.candidates.controller.dto;

import com.application.jobboard.applicants.domain.Applicant;
import com.application.jobboard.candidates.domain.Candidate;
import com.application.jobboard.companies.domain.Company;

public class CandidateDto {

    private Candidate candidate;
    private long jobId;


    public CandidateDto() {

    }

    public CandidateDto(Candidate candidate, long jobId){
        this.candidate = candidate;
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

}
