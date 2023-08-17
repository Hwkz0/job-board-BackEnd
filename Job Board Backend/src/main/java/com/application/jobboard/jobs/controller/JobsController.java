package com.application.jobboard.jobs.controller;


import com.application.jobboard.auth.exception.EntityNotFoundException;
import com.application.jobboard.jobs.domain.Job;
import com.application.jobboard.jobs.repository.JobsRepository;
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
    Job newJob(@RequestBody Job registerJob) {

        return jobsRepository.save(registerJob);

    }

    @GetMapping("/job/all-jobs")
    List<Job> getAllJobs() {

        return jobsRepository.findAll();

    }


    @GetMapping("/job/{getJobById}")
    Job getJobById(Long getJobById) {

        return jobsRepository.findById(getJobById)
                .orElseThrow(() -> new EntityNotFoundException(getJobById, entityType));

    }



    @PutMapping("/job/update/{idOfJobToBeUpdated}")
    Job updateJobs(@RequestBody Job updateJob, @PathVariable Long idOfJobToBeUpdated) {

        return jobsRepository.findById(idOfJobToBeUpdated)
                .map(job -> {

                    job.setJobTitle(updateJob.getJobTitle());

//                    job.setJobDescription(updateJobs.getJobDescription());

                    job.setJobLocation(updateJob.getJobLocation());

                    job.setJobType(updateJob.getJobType());

                    job.setJobSalary(updateJob.getJobSalary());
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
