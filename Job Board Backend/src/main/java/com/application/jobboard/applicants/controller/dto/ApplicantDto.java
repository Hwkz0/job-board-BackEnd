package com.application.jobboard.applicants.controller.dto;

import com.application.jobboard.applicants.domain.Applicant;

public class ApplicantDto {

    /*
        * The ApplicantDto is used to transfer data between different layers of the application.
     */

    private Applicant applicant;

    private Long jobId;


    /*
        * The ApplicantDto constructor is used to create an instance of the ApplicantDto class.
        * This creates an instance of the Applicant class with the jobId variable.
     */

    public ApplicantDto() {

    }

    public ApplicantDto(Applicant applicant, Long jobId) {
        this.applicant = applicant;
        this.jobId = jobId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

}
