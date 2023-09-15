package com.application.jobboard.ongoing.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class ActiveJob {

    private long activeId;
    private long userId;
    private long companyId;
    private String userFirstName;
    private String userLastName;
    private String companyName;
    private String companyAddress;
    private String companyPhone;
    private boolean activeStatus;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private long paymentId;

    @Builder
    public ActiveJob(long activeId, long userId, long companyId, String userFirstName, String userLastName, String companyName, String companyAddress, String companyPhone, boolean activeStatus, ZonedDateTime startDate, ZonedDateTime endDate, long paymentId) {
        this.activeId = activeId;
        this.userId = userId;
        this.companyId = companyId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhone = companyPhone;
        this.activeStatus = activeStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paymentId = paymentId;
    }


}
