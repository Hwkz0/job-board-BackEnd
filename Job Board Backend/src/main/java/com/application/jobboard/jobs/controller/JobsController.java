package com.application.jobboard.jobs.controller;


import com.application.jobboard.auth.exception.EntityNotFoundException;
import com.application.jobboard.jobs.domain.Jobs;
import com.application.jobboard.jobs.repository.JobsRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobsController {

    private final String entityType = "Job";

    @Autowired
    private JobsRepository jobsRepository;


    @PostMapping("/job/register")
    Jobs newJob(@RequestBody Jobs registerJob) {

        return jobsRepository.save(registerJob);

    }

    @GetMapping("/job/all-jobs")
    List<Jobs> getAllJobs() {

        return jobsRepository.findAll();

    }


    @GetMapping("/job/{getJobById}")
    Jobs getJobById(Long getJobById) {

        return jobsRepository.findById(getJobById)
                .orElseThrow(() -> new EntityNotFoundException(getJobById, entityType));

    }



    @PutMapping("/job/update/{idOfJobToBeUpdated}")
    Jobs updateJobs(@RequestBody Jobs updateJobs, @PathVariable Long idOfJobToBeUpdated) {

        return jobsRepository.findById(idOfJobToBeUpdated)
                .map(job -> {

                    job.setJobTitle(updateJobs.getJobTitle());

//                    job.setJobDescription(updateJobs.getJobDescription());

                    job.setJobLocation(updateJobs.getJobLocation());

                    job.setJobType(updateJobs.getJobType());

                    job.setJobSalary(updateJobs.getJobSalary());
//
//                    job.setJobRequiredExperience(updateJobs.getJobRequiredExperience());
//
//                    job.setJobRequiredQualification(updateJobs.getJobRequiredQualification());
//
//                    job.setJobPostedDate(updateJobs.getJobPostedDate());
//
//                    job.setJobApplicationDeadline(updateJobs.getJobApplicationDeadline());

                    return jobsRepository.save(job);

                })
                .orElseThrow(() -> new EntityNotFoundException(idOfJobToBeUpdated, entityType));


    }


    @DeleteMapping("/job/delete/{deleteJobId}")
    String deleteJob(@PathVariable Long deleteJobId) {

        if(jobsRepository.existsById(deleteJobId)) {

            jobsRepository.deleteById(deleteJobId);

            return "Job " + deleteJobId + " has been deleted";

        }
        else {

            throw new EntityNotFoundException(deleteJobId, entityType);

        }

    }





}
