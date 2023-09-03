package com.application.jobboard.job.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;

@Getter
public class Job {

        private long jobId;
        private BigInteger categoryId;
        private String jobTitle;
        private String jobDescription;
        private String jobLocation;
        private long jobPay;
        private Boolean isRemote;
        private Boolean isOnSite;
        private Boolean isHybrid;


        @Builder
        public Job (long jobId, BigInteger categoryId, String jobTitle, String jobDescription, String jobLocation, long jobPay, Boolean isRemote, Boolean isOnSite, Boolean isHybrid) {
            this.jobId = jobId;
            this.categoryId = categoryId;
            this.jobTitle = jobTitle;
            this.jobDescription = jobDescription;
            this.jobLocation = jobLocation;
            this.jobPay = jobPay;
            this.isRemote = isRemote;
            this.isOnSite = isOnSite;
            this.isHybrid = isHybrid;
        }

}
