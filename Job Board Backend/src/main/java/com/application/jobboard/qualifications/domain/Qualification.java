package com.application.jobboard.qualifications.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
public class Qualification {

    private long qualificationId;

    private String qualificationName;

    private String qualificationDescription;

    private Long qualificationPrice;

    private String qualificationType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime endDate;

    @Builder
    public Qualification(long qualificationId, String qualificationName, String qualificationDescription, Long qualificationPrice, String qualificationType, ZonedDateTime endDate) {
        this.qualificationId = qualificationId;
        this.qualificationName = qualificationName;
        this.qualificationDescription = qualificationDescription;
        this.qualificationPrice = qualificationPrice;
        this.qualificationType = qualificationType;
        this.endDate = endDate.withZoneSameInstant(ZoneId.systemDefault());
    }

}
