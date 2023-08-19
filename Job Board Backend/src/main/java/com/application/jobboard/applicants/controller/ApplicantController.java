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


    /*
        * The entityType variable is used to store the name of the entity type that is being used in the controller.
        * This is used in the EntityNotFoundException class.
        * Used to display the name of the entity type in the error message.
        * Its only purpose is convenience and to make the code more readable.
     */
    private final String entityType = "Applicant";

    /*
        * The applicantRepository variable is used to call the methods in the ApplicantRepository interface.
        * This is done by using the @Autowired annotation.
        * Done so that we can use the methods in the ApplicantRepository interface.
     */


    @Autowired
    private ApplicantRepository applicantRepository;


    /*
        * The newApplicant method is used to register a new applicant.
        * This is done by using the @PostMapping annotation.
        * The @RequestBody annotation is used to bind the request body with a method parameter.
        * This method takes in an Applicant object as a parameter.
        * The method returns an Applicant object.
        * And uses the save method from the ApplicantRepository interface.
        * The method saves the applicant to the database.

     */

    @PostMapping("/applicant/register")
    Applicant newApplicant(@RequestBody Applicant registerApplicant) {

        return applicantRepository.save(registerApplicant);

    }


    /*
        * The getAllApplicants method is used to get all the applicants.
        * This is done by using the @GetMapping annotation.
        * The method returns a list of Applicant objects.
        * And uses the findAll method from the ApplicantRepository interface.
        * The method returns all the applicants from the database.
     */


    @GetMapping("/applicant/all-applicants")
    List<Applicant> getAllApplicants() {

        return applicantRepository.findAll();

    }


    /*
        * The getApplicantById method is used to get an applicant by their id.
        * This is done by using the @GetMapping annotation.
        * The method takes in a Long variable as a parameter which is the applicant ID.
        * The method returns an Applicant object.
        * And uses the findById method from the ApplicantRepository interface.
        * The method returns the applicant with the specified id from the database.
        * If the applicant with the specified id does not exist in the database then the method throws an EntityNotFoundException.
     */



    @GetMapping("/applicant/{getApplicantById}")
    Applicant getApplicantById(Long getApplicantById) {

        return applicantRepository.findById(getApplicantById)
                .orElseThrow(() -> new EntityNotFoundException(getApplicantById, entityType));

    }


    /*
        *The updateApplicant method is used to update an applicant.
        * This is done by using the @PutMapping annotation.
        * The @RequestBody annotation is used to bind the request body with a method parameter.
        * This method takes in an Applicant object and a Long variable as parameters.
        * The Applicant object is the applicant that will be updated.
        * The Long variable is the id of the applicant that will be updated in the database so that we return the updated applicant in its place.
        * The method returns an Applicant object.
     */



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

    /*
        * The deleteApplicant method is used to delete an applicant.
        * This is done by using the @DeleteMapping annotation.
        * The method takes in a Long variable as a parameter which is the applicant ID.
        * The method returns a confirmation message.
        * If the applicant with the specified id does not exist in the database then the method throws an EntityNotFoundException.
     */



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
