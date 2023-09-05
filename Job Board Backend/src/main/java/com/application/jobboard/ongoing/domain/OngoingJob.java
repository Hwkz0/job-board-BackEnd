package com.application.jobboard.ongoing.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OngoingJob {

    private long userId;
    private long ongoingId;
    private long jobId;

    @Builder
    public OngoingJob(long userId, long ongoingId, long jobId) {
        this.userId = userId;
        this.ongoingId = ongoingId;
        this.jobId = jobId;
    }



}
