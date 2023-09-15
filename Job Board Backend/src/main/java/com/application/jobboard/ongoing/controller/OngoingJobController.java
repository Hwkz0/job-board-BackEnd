package com.application.jobboard.ongoing.controller;


import com.application.jobboard.auth.AuthRequired;
import com.application.jobboard.global.common.StatusEnum;
import com.application.jobboard.global.common.SuccessResponse;
import com.application.jobboard.ongoing.controller.dto.JobRequestDto;
import com.application.jobboard.ongoing.service.OngoingJobService;
import com.application.jobboard.user.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OngoingJobController {

    private final OngoingJobService ongoingJobService;
    private final LoginService loginService;

    public OngoingJobController(OngoingJobService ongoingJobService, @Qualifier("userSessionLoginService") LoginService loginService){
        this.ongoingJobService = ongoingJobService;
        this.loginService = loginService;
    }

    @Transactional
    @AuthRequired
    @PostMapping("/ongoing-job")
    public SuccessResponse activeJob(@Valid @RequestBody JobRequestDto dto){
        long userId = loginService.getLoginUserId();
        ongoingJobService.activeJob(userId, dto);
        SuccessResponse successResponse = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("Job application successful")
                .build();

        return successResponse;
    }

}
