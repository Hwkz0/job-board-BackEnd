package com.application.jobboard.applications.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.jobboard.auth.AuthRequired;
import com.application.jobboard.applications.service.JobApplicationService;
import com.application.jobboard.global.common.StatusEnum;
import com.application.jobboard.global.common.SuccessResponse;
import com.application.jobboard.job.controller.dto.SaveJobApplicationRequest;


//TODO: COME BACK TO THIS



public class JobApplicationController {
}
