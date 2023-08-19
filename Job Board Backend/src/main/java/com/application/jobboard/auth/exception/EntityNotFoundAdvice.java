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


    /*
        * The entityNotFoundHandler method is used to handle the EntityNotFoundException.
        * This is done by using the @ExceptionHandler annotation.
        * The @ResponseBody annotation is used to bind the return value to the body of the response.
     */


    @ResponseBody

    @ExceptionHandler(EntityNotFoundException.class)

    @ResponseStatus(HttpStatus.NOT_FOUND)

    public Map<String, String> entityNotFoundHandler(EntityNotFoundException exception) {

        Map<String,String> erorMap = new HashMap<>();

        erorMap.put("message", exception.getMessage());

        return erorMap;


    }

}
