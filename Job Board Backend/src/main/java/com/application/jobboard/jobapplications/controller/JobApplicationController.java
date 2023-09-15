package com.application.jobboard.jobapplications.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.jobboard.auth.AuthRequired;
import com.application.jobboard.jobapplications.service.JobApplicationService;
import com.application.jobboard.global.common.StatusEnum;
import com.application.jobboard.global.common.SuccessResponse;
import com.application.jobboard.job.controller.dto.SaveJobApplicationRequest;
import com.application.jobboard.user.service.LoginService;

@RestController
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;
    private final LoginService loginService;

    public JobApplicationController(JobApplicationService jobApplicationService, @Qualifier("userSessionLoginService") LoginService loginService){
        this.jobApplicationService = jobApplicationService;
        this.loginService = loginService;
    }

    @AuthRequired
    @PostMapping("/job-application")
    public SuccessResponse saveJobApplication(@Valid @RequestBody final SaveJobApplicationRequest dto){
        long userId = loginService.getLoginUserId();
        jobApplicationService.saveJobApplication(userId, dto);
        return SuccessResponse.builder()
                .status(StatusEnum.OK)
                .message("Job application saved successfully")
                .build();
    }


}
