package com.application.jobboard.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

    private long userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String userPhone;
    private String userSalt;

    @Builder
    public User(long userId, String userFirstName, String userLastName, String userEmail, String userPassword, String userPhone, String userSalt) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userSalt = userSalt;
    }

}
