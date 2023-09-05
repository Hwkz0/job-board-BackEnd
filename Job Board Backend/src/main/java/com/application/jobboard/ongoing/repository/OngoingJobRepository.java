package com.application.jobboard.ongoing.repository;

import com.application.jobboard.job.domain.Job;
import com.application.jobboard.ongoing.domain.Active;
import com.application.jobboard.ongoing.domain.OngoingJob;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OngoingJobRepository {

    void insertActiveJob(Active active);

    void insertOngoingJob(OngoingJob ongoingJob);

    List<Job> findJobByUserId(long userId);

}
