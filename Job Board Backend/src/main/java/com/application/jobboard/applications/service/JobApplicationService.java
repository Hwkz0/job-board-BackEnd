package com.application.jobboard.applications.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.jobboard.applications.domain.JobApplication;
import com.application.jobboard.applications.repository.JobApplicationRepository;
import com.application.jobboard.job.service.JobService;
import com.application.jobboard.job.controller.dto.SaveJobApplicationRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final JobService jobService;

    @Transactional
    public void saveJobApplication(long userId, SaveJobApplicationRequest dto){
        if(!jobService.checkIsJobExist(dto.getJobId())){
            throw new IllegalArgumentException("Job does not exist");
        }

        JobApplication jobApplication = JobApplication.builder()
                .jobId(dto.getJobId())
                .userId(userId)
                .build();
        if (!checkIsJobApplicationExist(jobApplication))
            jobApplicationRepository.addJobApplication(jobApplication);
        else {
            throw new IllegalArgumentException("Job application already exists");
        }
    }

    public boolean checkIsJobApplicationExist(JobApplication jobApplication){
        return jobApplicationRepository.findByApplicationId(jobApplication.getUserId(), jobApplication.getJobId()).isPresent();
    }



}
