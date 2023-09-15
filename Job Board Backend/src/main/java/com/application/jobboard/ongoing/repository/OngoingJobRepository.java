package com.application.jobboard.ongoing.repository;

import com.application.jobboard.ongoing.domain.ActiveJob;
import com.application.jobboard.ongoing.domain.OngoingJob;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OngoingJobRepository {

    static void insertActiveJob(ActiveJob active) {};

    void insertOngoingJob(OngoingJob ongoingJob);

    List<ActiveJob> findJobByUserId(long userId);

}
