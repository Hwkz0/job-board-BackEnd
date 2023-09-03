package com.application.jobboard.job.repository;

import com.application.jobboard.job.domain.Job;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.math.BigInteger;

@Mapper
@Repository
public interface JobRepository {

    List<Job> findJobsByIsRemote(Boolean isRemote, int listStart, int listSize);
    List<Job> findJobsByIsOnSite(Boolean isOnSite, int listStart, int listSize);
    List<Job> findJobsByIsHybrid(Boolean isHybrid, int listStart, int listSize);
    List<Job> findJobsByIsRemoteAndIsHybrid(Boolean isRemote, Boolean isHybrid, int listStart, int listSize);
    List<Job> findJobsByIsRemoteAndIsOnSite(Boolean isRemote, Boolean isOnSite, int listStart, int listSize);
    List<Job> findJobsByKeyword(String keyword);
    Optional<Job> findJobByJobId(long jobId);


}
