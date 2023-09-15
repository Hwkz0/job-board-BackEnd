package com.application.jobboard.payment.controller.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PaymentDto {

    @NotNull
    private PaymentType paymentType;

    private long bonus;

    @NotNull
    private long totalPay;

    @Builder
    public PaymentDto(@NotNull PaymentType paymentType, long bonus, @NotNull long totalPay) {
        this.paymentType = paymentType;
        this.bonus = bonus;
        this.totalPay = totalPay;
    }
}
