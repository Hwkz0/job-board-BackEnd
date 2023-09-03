package com.application.jobboard.job.controller.dto;

import com.application.jobboard.job.domain.Job;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class SimpleJob {

    @NotNull
    private long jobId;

    @NotNull
    private String jobTitle;

    @NotNull
    private String jobDescription;

    @NotNull
    private String jobLocation;

    @NotNull
    private long jobPay;

    @Builder
    public SimpleJob(long jobId, String jobTitle, String jobDescription, String jobLocation, long jobPay) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobLocation = jobLocation;
        this.jobPay = jobPay;
    }

    public static SimpleJob toResponse(Job job) {
        return SimpleJob.builder()
                .jobId(job.getJobId())
                .jobTitle(job.getJobTitle())
                .jobDescription(job.getJobDescription())
                .jobLocation(job.getJobLocation())
                .jobPay(job.getJobPay())
                .build();
    }

    public static List<SimpleJob> toList(List<Job> jobs) {
        return jobs.stream()
                .map(SimpleJob::toResponse)
                .collect(Collectors.toList());
    }


}
