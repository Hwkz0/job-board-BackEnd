package com.application.job_board.user.domain;


import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

    private long userId;

    private String userName;

    private String userEmailAddress;

    private String userPassword;

    private String userPhoneNumber;


    @Builder
    public User(long userId, String userName, String userEmailAddress, String userPassword, String userPhoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userEmailAddress = userEmailAddress;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
    }

}
