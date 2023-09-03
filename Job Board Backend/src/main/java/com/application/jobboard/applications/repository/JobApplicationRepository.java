package com.application.jobboard.applications.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.application.jobboard.applications.domain.JobApplication;

@Mapper
@Repository
public interface JobApplicationRepository {

    List<JobApplication> findByUserId(Long userId);

    void addJobApplication(JobApplication jobApplication);

    void deleteJobApplication(JobApplication jobApplication);

    Optional<JobApplication> findByApplicationId(long userId, long applicationId);

}
