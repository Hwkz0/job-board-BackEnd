package com.application.jobboard.user.service;

import com.application.jobboard.user.controller.dto.LoginRequestDto;

public interface LoginService   {

    void login(LoginRequestDto dto);

    void logout();

    long getCurrentUserId();


}
