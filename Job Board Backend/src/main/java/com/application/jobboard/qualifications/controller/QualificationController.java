package com.application.jobboard.qualifications.controller;

import com.application.jobboard.auth.AuthRequired;
import com.application.jobboard.global.common.StatusEnum;
import com.application.jobboard.global.common.SuccessResponse;
import com.application.jobboard.qualifications.domain.Qualification;
import com.application.jobboard.qualifications.service.QualificationService;
import com.application.jobboard.user.service.LoginService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QualificationController {

    private final QualificationService qualificationService;
    private final LoginService loginService;

    public QualificationController (QualificationService qualificationService,  @Qualifier("userSessionLoginService") LoginService loginService) {
        this.qualificationService = qualificationService;
        this.loginService = loginService;
    }

    @GetMapping("/qualifications")
    public SuccessResponse getAllQualifications() {
        List<Qualification> qualifications = qualificationService.getAllQualifications();
        SuccessResponse response = SuccessResponse.builder()
                .status(StatusEnum.OK)
                .message("Qualifications retrieved successfully")
                .data(qualifications)
                .build();
        return response;
    }

    @AuthRequired
    @PostMapping("/qualifications/{qualificationId}")
    public SuccessResponse addQualification(@PathVariable("qualificationId") final Long qualificationId) {
        Long userId = loginService.getLoginUserId();
        qualificationService.addQualification(qualificationId, userId);
        SuccessResponse response = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("Qualification added successfully")
                .build();
        return response;

    }

}
