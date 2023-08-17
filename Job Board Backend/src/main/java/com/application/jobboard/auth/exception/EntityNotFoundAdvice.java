package com.application.jobboard.auth.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EntityNotFoundAdvice {

    @ResponseBody

    @ExceptionHandler(EntityNotFoundException.class)

    @ResponseStatus(HttpStatus.NOT_FOUND)

    public Map<String, String> userNotFoundHandler(EntityNotFoundException exception) {

        Map<String,String> erorMap = new HashMap<>();

        erorMap.put("message", exception.getMessage());

        return erorMap;


    }

}
