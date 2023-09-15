package com.application.jobboard.ongoing.service;


import java.util.List;
import java.util.Optional;

import com.application.jobboard.job.domain.Job;
import com.application.jobboard.jobapplications.domain.JobApplication;
import com.application.jobboard.job.repository.JobRepository;
import com.application.jobboard.ongoing.controller.dto.JobRequestDto;
import com.application.jobboard.payment.controller.dto.PaymentDto;
import com.application.jobboard.payment.domain.Payment;
import com.application.jobboard.user.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.jobboard.qualifications.service.QualificationService;
import com.application.jobboard.payment.service.PaymentService;
import com.application.jobboard.address.repository.AddressRepository;
import com.application.jobboard.jobapplications.repository.JobApplicationRepository;
import com.application.jobboard.global.constant.CacheKey;
import com.application.jobboard.ongoing.domain.ActiveJob;
import com.application.jobboard.ongoing.repository.OngoingJobRepository;
import com.application.jobboard.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class OngoingJobService {

    private final JobApplicationRepository jobApplicationRepository;
    private final AddressRepository addressRepository;
    private final QualificationService qualificationService;
    private final PaymentService paymentService;
    private final OngoingJobRepository ongoingJobRepository;
    private final JobRepository jobRepository;
    private final UserRepository userRepository;


    @Transactional(readOnly = true)
    @Cacheable(key = "#userId", value = CacheKey.ONGOING_JOBS_INFO)
    public List<ActiveJob> getOngoingJobInfo(long userId){

        List <ActiveJob> activeJobsPaycheck = ongoingJobRepository.findJobByUserId(userId);

        return activeJobsPaycheck;
    }


    @Transactional
    public void activeJob(long userId, JobRequestDto jobRequestDto) {

        List <JobApplication> jobApplications = jobApplicationRepository.findByUserId(userId);

        PaymentDto paymentDto = PaymentDto.builder()
                .paymentType(jobRequestDto.getPaymentType())
                .build();

        try{
            paymentService.pay(paymentDto);
        }catch (Exception e){
            throw new IllegalArgumentException("Payment failed", e );
        }

        Payment payment = Payment.builder()
                .type(paymentDto.getPaymentType().ordinal())
                .totalPay(paymentDto.getTotalPay())
                .status(true)
                .bonus(paymentDto.getBonus())
                .build();
        long paymentId = paymentService.savePayment(payment);

        long ongoingJobId = saveOngoingJobInfo(userId, paymentId, jobRequestDto);

        deleteJobApplication(jobApplications);

    }

    public long saveOngoingJobInfo(long userId,long paymentId, JobRequestDto jobRequestDto) {

        User userInfo = userRepository.findByUserId(userId);
        String companyAddress = addressRepository.findAddressByUserId(userId);

        ActiveJob activeJob = ActiveJob.builder()
                .userId(userId)
                .userFirstName(userInfo.getUserFirstName())
                .userLastName(userInfo.getUserLastName())
                .companyName(jobRequestDto.getCompanyName())
                .companyAddress(companyAddress)
                .companyPhone(jobRequestDto.getCompanyPhone())
                .paymentId(paymentId)
                .activeStatus(false)
                .build();

        OngoingJobRepository.insertActiveJob(activeJob);

        return activeJob.getActiveId();

    }


    public void deleteJobApplication(List<JobApplication> jobApplications) {
        jobApplications.stream()
                .forEach(jobApplicationRepository::deleteJobApplication);
    }


}
