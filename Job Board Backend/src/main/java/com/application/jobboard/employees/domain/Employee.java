package com.application.jobboard.employees.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Employee {

    @Id
    @GeneratedValue
    private long employeeId;

    private String employeeFirstName;

    private String employeeLastName;

    private String employeeEmailAddress;

    private String employeePassword;

    private String employeePhoneNumber;


}
