package com.application.jobboard.job.controller.dto;

import jakarta.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class SaveJobApplicationRequest {

    @NotNull
    private long jobId;

    @Builder
    public SaveJobApplicationRequest(long jobId) {

        this.jobId = jobId;
    }
}
