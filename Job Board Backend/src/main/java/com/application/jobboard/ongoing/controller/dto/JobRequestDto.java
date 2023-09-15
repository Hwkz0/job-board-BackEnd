package com.application.jobboard.ongoing.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;

import com.application.jobboard.payment.controller.dto.PaymentType;


import lombok.Builder;
import lombok.Getter;

@Getter
public class JobRequestDto {

    @NotNull
    private PaymentType paymentType;

    @NotNull
    private String companyName;

    @NotNull
    private String companyPhone;

    @Max(50)
    @NotNull
    private String receiverRequest;


    @Builder
    public JobRequestDto(PaymentType paymentType, String companyName, String companyPhone, String receiverRequest) {
        this.paymentType = paymentType;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.receiverRequest = receiverRequest;
    }

}
