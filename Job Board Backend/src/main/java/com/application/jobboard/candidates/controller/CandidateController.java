package com.application.jobboard.candidates.controller;


import com.application.jobboard.auth.exception.EntityNotFoundException;
import com.application.jobboard.candidates.domain.Candidate;
import com.application.jobboard.candidates.repository.CandidateRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class CandidateController {

    private final String entityType = "Candidate";

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/candidate/register")
    Candidate newCandidate(@RequestBody Candidate registerCandidate) {

        return candidateRepository.save(registerCandidate);

    }


    @GetMapping("/candidate/all-candidates")
    List<Candidate> getAllCandidates() {

        return candidateRepository.findAll();

    }

    @GetMapping("/candidate/{getCandidateById}")
    Candidate getCandidateById(Long candidateId){
        return candidateRepository.findById(candidateId)
                .orElseThrow(() -> new EntityNotFoundException(candidateId, entityType));
    }


    @PutMapping("/candidate/update/{idOfCandidateToBeUpdated}")
    Candidate updateCandidate(@RequestBody Candidate updateCandidate, @PathVariable Long idOfCandidateToBeUpdated) {

        return candidateRepository.findById(idOfCandidateToBeUpdated)
                .map(candidate -> {

                   candidate.setCandidateId(updateCandidate.getCandidateId());
                   candidate.getApplicant().setApplicantId(updateCandidate.getApplicant().getApplicantId());
                   candidate.getJob().setJobId(updateCandidate.getJob().getJobId());
                   candidate.setCandidateStatus(updateCandidate.getCandidateStatus());
                   candidate.setCandidateResponse(updateCandidate.isCandidateResponse());

                    return candidateRepository.save(candidate);

                })
                .orElseThrow(() -> new EntityNotFoundException(idOfCandidateToBeUpdated, entityType));
    }


    @DeleteMapping("/candidate/delete/{idOfCandidateToBeDeleted}")
    String deleteCandidate(@PathVariable Long idOfCandidateToBeDeleted) {

        if (candidateRepository.existsById(idOfCandidateToBeDeleted)) {

            candidateRepository.deleteById(idOfCandidateToBeDeleted);

            return "Candidate with id " + idOfCandidateToBeDeleted + " has been deleted";

        } else {

            throw new EntityNotFoundException(idOfCandidateToBeDeleted, entityType);

        }

    }










}
