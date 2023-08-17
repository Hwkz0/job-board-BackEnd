package com.application.jobboard.applicants.controller;

import com.application.jobboard.auth.exception.EntityNotFoundException;
import com.application.jobboard.applicants.domain.Applicant;
import com.application.jobboard.applicants.repository.ApplicantRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-board/applicant")
public class ApplicantController {

    private final String entityType = "Applicant";

    @Autowired
    private ApplicantRepository applicantRepository;

    @PostMapping("/applicant/register")
    Applicant newApplicant(@RequestBody Applicant registerApplicant) {

        return applicantRepository.save(registerApplicant);

    }

    @GetMapping("/applicant/all-applicants")
    List<Applicant> getAllApplicants() {

        return applicantRepository.findAll();

    }


    @GetMapping("/applicant/{getApplicantById}")
    Applicant getApplicantById(Long getApplicantById) {

        return applicantRepository.findById(getApplicantById)
                .orElseThrow(() -> new EntityNotFoundException(getApplicantById, entityType));

    }


    @PutMapping("/applicant/update/{idOfApplicantToBeUpdated}")
    Applicant updateApplicant(@RequestBody Applicant updateApplicant, @PathVariable Long idOfApplicantToBeUpdated) {

       return applicantRepository.findById(idOfApplicantToBeUpdated)
               .map(applicant -> {

                     applicant.setApplicantFirstName(updateApplicant.getApplicantFirstName());

                     applicant.setApplicantLastName(updateApplicant.getApplicantLastName());

                     applicant.setApplicantEmailAddress(updateApplicant.getApplicantEmailAddress());

                     applicant.setApplicantPassword(updateApplicant.getApplicantPassword());

                     applicant.setApplicantPhoneNumber(updateApplicant.getApplicantPhoneNumber());

                     return applicantRepository.save(applicant);

                })

               .orElseThrow(() -> new EntityNotFoundException(idOfApplicantToBeUpdated, entityType));

    }


    @DeleteMapping("/applicant/delete/{applicantIdToBeDeleted}")
    String deleteApplicant(@PathVariable Long applicantIdToBeDeleted) {

        if (applicantRepository.existsById(applicantIdToBeDeleted)) {

            applicantRepository.deleteById(applicantIdToBeDeleted);
            return "Applicant with id "+ applicantIdToBeDeleted + "deleted successfully.";

        } else {

            throw new EntityNotFoundException(applicantIdToBeDeleted, entityType);

        }

    }



}
