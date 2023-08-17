package com.application.jobboard.applicants.controller.dto;

import com.application.jobboard.applicants.domain.Applicant;

public class ApplicantDto {

    Applicant applicant;
    String jobId;

    public ApplicantDto(Applicant applicant, String jobId) {
        this.applicant = applicant;
        this.jobId = jobId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

}
