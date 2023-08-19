package com.application.jobboard.applicants.domain;


import com.application.jobboard.jobs.domain.Job;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "applicants")
public class Applicant {

   /*
        First we have the applicant id field.
        This is the primary key for the Applicant class.
        We do this so that we can uniquely identify each applicant in the database.
        Done by using the @Id annotation.
        @GeneratedValue is used so that the applicant id is generated automatically.
        It takes a GenerationType.IDENTITY parameter.
    */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicantId;


    /*
        Next we have fields for the Applicant class.
        These fields are applicant first name, applicant last name, applicant email address, applicant password and applicant phone number.
        These fields are so that we can store the mentioned data about the applicant in the database.
    */


    @Column(name = "applicant_first_name")
    private String applicantFirstName;

    @Column(name = "applicant_last_name")
    private String applicantLastName;

    @Column(name = "applicant_email_address")
    private String applicantEmailAddress;

    @Column(name = "applicant_password")
    private String applicantPassword;

    @Column(name = "applicant_phone_number")
    private String applicantPhoneNumber;



    /*
        Next we have a many-to-many relationship between the Applicant class and the Job class.
        This is so that we can have multiple jobs for each applicant.
        This is done by using the @OneToMany annotation.
        This joins the applicant id from the Applicant class to the applicant id in the Job class.
    */



    @ManyToMany
    @JoinTable(
            name = "applicants_jobs",
            joinColumns = @JoinColumn(name = "applicant_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private List<Job> jobs;


    /*
        Next we have 3 constructors with different parameter lists for the Applicant class.
        This is to provide flexibility when creating new instances of the Applicant class.
        Also this provices convenience for future developers who may use this code.
    */




    //default constructor
    public Applicant() {

    }

    //constructor for applicant but without applicant id
    public Applicant(String applicantFirstName, String applicantLastName, String applicantEmailAddress, String applicantPassword, String applicantPhoneNumber) {

        this.applicantFirstName = applicantFirstName;

        this.applicantLastName = applicantLastName;

        this.applicantEmailAddress = applicantEmailAddress;

        this.applicantPassword = applicantPassword;

        this.applicantPhoneNumber = applicantPhoneNumber;

    }

    /*
        Next we have getters and setters for each of the fields in the Applicant class.
        This is so that we can access the fields in the Applicant class from other classes.
    */

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
