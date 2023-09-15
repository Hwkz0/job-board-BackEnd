package com.application.jobboard.payment.domain;

import java.time.ZonedDateTime;

import com.application.jobboard.payment.controller.dto.PaymentType;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Payment {

    private long paymentId;

    private int type;

    private long bonus;

    private long totalPay;

    private boolean status;

    private ZonedDateTime createdAt;

    @Builder
    public Payment(long paymentId, int type, long bonus, long totalPay, boolean status, ZonedDateTime createdAt) {
        this.paymentId = paymentId;
        this.type = type;
        this.bonus = bonus;
        this.totalPay = totalPay;
        this.status = status;
        this.createdAt = createdAt;
    }

}
