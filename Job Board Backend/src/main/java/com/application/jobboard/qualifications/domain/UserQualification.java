package com.application.jobboard.qualifications.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserQualification {

    private Long userQualificationId;

    private Long userId;

    private Long qualificationId;

    @Builder
    public UserQualification(Long userQualificationId, Long userId, Long qualificationId) {
        this.userQualificationId = userQualificationId;
        this.userId = userId;
        this.qualificationId = qualificationId;
    }


}
