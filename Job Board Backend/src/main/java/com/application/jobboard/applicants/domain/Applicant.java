package com.application.jobboard.applicants.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


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

    public void setApplicantPhoneNumber(String applicantPhoneNumber) {
        this.applicantPhoneNumber = applicantPhoneNumber;
    }


}
