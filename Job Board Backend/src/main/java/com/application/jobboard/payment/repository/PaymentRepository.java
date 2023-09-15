package com.application.jobboard.payment.repository;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.application.jobboard.payment.domain.Payment;

@Mapper
@Repository
public interface PaymentRepository {

    void insertPayment(Payment payment);

}
