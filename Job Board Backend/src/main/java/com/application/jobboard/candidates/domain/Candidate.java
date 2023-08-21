package com.application.jobboard.candidates.domain;


import com.application.jobboard.applicants.domain.Applicant;
import com.application.jobboard.jobs.domain.Job;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long candidateId;

    @Column(name = "candidate_status")
    private String candidateStatus;

    @Column(name = "candidate_response")
    private boolean candidateResponse;


    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;


    public Candidate() {

    }

    public Candidate(Applicant applicant, Job job, String candidateStatus, boolean candidateResponse) {
        this.applicant = applicant;
        this.job = job;
        this.candidateStatus = candidateStatus;
        this.candidateResponse = candidateResponse;
    }


    public Long getCandidateId() {
        return candidateId;
    }
    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }
    public String getCandidateStatus() {
        return candidateStatus;
    }
    public void setCandidateStatus(String candidateStatus) {
        this.candidateStatus = candidateStatus;
    }
    public boolean isCandidateResponse() {
        return candidateResponse;
    }
    public void setCandidateResponse(boolean candidateResponse) {
        this.candidateResponse = candidateResponse;
    }


    public Applicant getApplicant() {
        return applicant;
    }
    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }


    public Job getJob() {
        return job;
    }
    public void setJob(Job job) {
        this.job = job;
    }



}
