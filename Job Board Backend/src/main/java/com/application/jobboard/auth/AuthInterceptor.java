package com.application.jobboard.auth;

import com.application.jobboard.auth.exception.NoAuthData;
import com.application.jobboard.auth.exception.UnauthorizedException;
import com.application.jobboard.global.constant.SessionKey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws UnauthorizedException {
        try {
            if (isNeedToAuth((HandlerMethod) handler)) {
                getUserIdBySession(request);
            }
            return true;
        } catch (Exception e) {
            throw new UnauthorizedException();
        }
    }

    private boolean isNeedToAuth(HandlerMethod handler){

        if (handler.getMethodAnnotation(AuthRequired.class) == null){
            return false;
        }
        return true;
    }

    private String getUserIdBySession(HttpServletRequest request) throws NoAuthData {
        HttpSession session = request.getSession();
        return Optional.ofNullable(session.getAttribute(SessionKey.LOGIN_USER_ID))
                .map(v -> v.toString())
                .orElseThrow(NoAuthData::new);
    }

}
