package com.application.jobboard.applicants.domain;


import com.application.jobboard.jobs.domain.Job;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Applicant {

    @Id
    @GeneratedValue
    private long applicantId;

    private String applicantFirstName;

    private String applicantLastName;

    private String applicantEmailAddress;

    private String applicantPassword;

    private String applicantPhoneNumber;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "applicantId")
    private List<Job> jobs;

    public Applicant() {

    }

    public Applicant(String applicantFirstName, String applicantLastName, String applicantEmailAddress, String applicantPassword, String applicantPhoneNumber) {

        this.applicantFirstName = applicantFirstName;

        this.applicantLastName = applicantLastName;

        this.applicantEmailAddress = applicantEmailAddress;

        this.applicantPassword = applicantPassword;

        this.applicantPhoneNumber = applicantPhoneNumber;

    }

    public Applicant(Long applicantId, String applicantFirstName, String applicantLastName, String applicantEmailAddress, String applicantPassword, String applicantPhoneNumber) {

        this.applicantId = applicantId;

        this.applicantFirstName = applicantFirstName;

        this.applicantLastName = applicantLastName;

        this.applicantEmailAddress = applicantEmailAddress;

        this.applicantPassword = applicantPassword;

        this.applicantPhoneNumber = applicantPhoneNumber;

    }


    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {

        this.applicantId = applicantId;
    }


    public String getApplicantLastName() {
        return applicantLastName;
    }

    public void setApplicantLastName(String applicantLastName) {
        this.applicantLastName = applicantLastName;
    }

    public String getApplicantFirstName() {

        return applicantFirstName;
    }

    public void setApplicantFirstName(String applicantName) {

        this.applicantFirstName = applicantName;
    }

    public String getApplicantEmailAddress() {
        return applicantEmailAddress;
    }

    public void setApplicantEmailAddress(String applicantEmailAddress) {
        this.applicantEmailAddress = applicantEmailAddress;
    }

    public String getApplicantPassword() {

        return applicantPassword;
    }

    public void setApplicantPassword(String applicantPassword) {

        this.applicantPassword = applicantPassword;
    }

    public String getApplicantPhoneNumber() {

        return applicantPhoneNumber;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void setApplicantPhoneNumber(String applicantPhoneNumber) {
        this.applicantPhoneNumber = applicantPhoneNumber;
    }


}
