package com.application.jobboard.jobapplications.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.application.jobboard.jobapplications.domain.JobApplication;

@Mapper
@Repository
public interface JobApplicationRepository {

    List<JobApplication> findByUserId(Long userId);

    void addJobApplication(JobApplication jobApplication);

    void deleteJobApplication(JobApplication jobApplication);

    Optional<JobApplication> findByJobApplicationId(long userId, long applicationId);

}
