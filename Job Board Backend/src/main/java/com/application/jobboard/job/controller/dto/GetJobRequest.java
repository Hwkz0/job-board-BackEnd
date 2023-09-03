package com.application.jobboard.job.controller.dto;

import com.application.jobboard.job.constant.JobTypeEnum;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.springframework.lang.Nullable;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class GetJobRequest {

    @NotNull
    private JobTypeEnum jobType;

    @Nullable
    private boolean isRemote;

    @NotNull
    @Min(1)
    private int listStart;

    @NotNull
    @Min(1)
    @Max(100)
    private int listSize;



    @Builder
    public GetJobRequest(JobTypeEnum jobType, boolean isRemote, int listStart, int listSize) {
        this.jobType = jobType;
        this.isRemote = isRemote;
        this.listStart = listStart;
        this.listSize = listSize;
    }

}
