package com.application.jobboard.job.service;

import com.application.jobboard.job.constant.JobTypeEnum;
import com.application.jobboard.job.controller.dto.GetJobRequest;
import com.application.jobboard.job.controller.dto.SimpleJob;
import com.application.jobboard.job.domain.Job;
import com.application.jobboard.job.repository.JobRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JobService {

    private final JobRepository jobRepository;

    public List<SimpleJob> getJobs(GetJobRequest dto){
        JobTypeEnum jobType = dto.getJobType();
        boolean isRemote = dto.isRemote();
        int listSize = dto.getListSize();
        int listStart = dto.getListStart();

        List<Job> jobs= getJobsByType(jobType, isRemote, listSize, listStart);

        return SimpleJob.toList(jobs);
    }

    private List<Job> getJobsByType(JobTypeEnum jobType, boolean isRemote, int listSize, int listStart){
        List<Job> jobs = new ArrayList<>();
        switch (jobType) {
            case REMOTE:
                jobs = jobRepository.findJobsByIsRemote(true, listStart, listSize);
                break;
            case ON_SITE:
                if (isRemote) {
                    jobs = jobRepository.findJobsByIsRemoteAndIsOnSite(true, true, listStart, listSize);
                } else {
                    jobs = jobRepository.findJobsByIsOnSite(true, listStart, listSize);
                }
                break;
            case HYBRID:
                if (isRemote) {
                    jobs = jobRepository.findJobsByIsRemoteAndIsHybrid(true, true, listStart, listSize);
                } else {
                    jobs = jobRepository.findJobsByIsHybrid(true, listStart, listSize);
                }
                break;
        }
        return jobs;
    }

    public List <SimpleJob> searchJobByKeyword(String keyword){
        List<Job> jobs = jobRepository.findJobsByKeyword(keyword);
        return SimpleJob.toList(jobs);
    }

    public boolean checkIsJobExist(long jobId){
        return jobRepository.findJobByJobId(jobId).isPresent();
    }

}
