package com.application.jobboard.ongoing.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;

@Getter
public class OngoingJobInfo {

    @NotNull
    private long jobId;

    @NotNull
    private String jobTitle;

    @NotNull
    private BigInteger jobPay;

    @Builder
    public OngoingJobInfo(@JsonProperty("jobId") long jobId, @JsonProperty("jobTitle") String jobTitle, @JsonProperty("jobPay") BigInteger jobPay) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobPay = jobPay;
    }

}
