package com.application.jobboard.payment.service;


import org.springframework.stereotype.Service;

import com.application.jobboard.payment.controller.dto.PaymentDto;
import com.application.jobboard.payment.domain.Payment;
import com.application.jobboard.payment.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public void pay(PaymentDto paymentDto){
        if (!mockPayment(paymentDto)) {
            throw new IllegalArgumentException("Payment failed");
        }
    }

    public boolean mockPayment(PaymentDto paymentDto) {
        return true;
    }

    public long savePayment(Payment payment){
        paymentRepository.insertPayment(payment);
        return payment.getPaymentId();
    }


}
