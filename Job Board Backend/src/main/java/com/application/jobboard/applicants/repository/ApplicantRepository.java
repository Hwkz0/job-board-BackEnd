package com.application.jobboard.applicants.repository;

import com.application.jobboard.applicants.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    /*
        * This is the ApplicantRepository interface.
        * Methods in this interface are used to perform CRUD operations on the database.
        * The methods in this interface are implemented by the JpaRepository interface.
     */

    Optional<Applicant> findByEmailAddress(String applicantEmailAddress);


}
