package com.application.jobboard.address.domain;

import lombok.Builder;
import lombok.Getter;


@Getter
public class Address {

    private long addressId;
    private boolean isPrimary;
    private String streetAddress;
    private String city;
    private long userId;

    @Builder
    public Address(long addressId, boolean isPrimary, String streetAddress, String city, long userId) {
        this.addressId = addressId;
        this.isPrimary = isPrimary;
        this.streetAddress = streetAddress;
        this.city = city;
        this.userId = userId;
    }

}
