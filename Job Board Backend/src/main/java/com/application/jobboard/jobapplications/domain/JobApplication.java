package com.application.jobboard.jobapplications.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JobApplication {

    private long applicationId;
    private long jobId;
    private long userId;

    @Builder
    public JobApplication(long applicationId, long jobId, long userId) {
        this.applicationId = applicationId;
        this.jobId = jobId;
        this.userId = userId;
    }


}
