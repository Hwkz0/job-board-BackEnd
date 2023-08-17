package com.application.jobboard.jobs.repository;

import com.application.jobboard.jobs.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Job, Long> {
}
