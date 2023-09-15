package com.application.jobboard.qualifications.service;

import com.application.jobboard.qualifications.domain.Qualification;
import com.application.jobboard.qualifications.domain.UserQualification;
import com.application.jobboard.qualifications.repository.QualificationRepository;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class QualificationService {

    private final QualificationRepository qualificationRepository;

    public List<Qualification> getAllQualifications(){
        List<Qualification> qualifications = qualificationRepository.getAllQualifications();

        List<Qualification> availableQualifications = qualifications.stream()
                .filter(qualification -> qualification.getEndDate().isAfter(ZonedDateTime.now()))
                .collect(Collectors.toList());

        return availableQualifications;
    }

    @Transactional
    public void addQualification(long qualificationId, long userId){
        if(!checkIsAvailableQualification(qualificationId))
            throw new IllegalArgumentException("Qualification is not available");

        if(!checkQualificationIsAlreadyHave(qualificationId, userId)){
            UserQualification userQualification = UserQualification.builder()
                    .qualificationId(qualificationId)
                    .userId(userId)
                    .build();
            qualificationRepository.addUserQualification(userQualification);
        }
        else{
            throw new IllegalArgumentException("Qualification is already obtained");
        }
    }

    public boolean checkIsAvailableQualification(long qualificationId) {
        ZonedDateTime expirationDate = qualificationRepository.findQualificationById(qualificationId).get().getEndDate();
        return expirationDate.isAfter(ZonedDateTime.now());
    }

    public boolean checkQualificationIsAlreadyHave(long qualificationId, long userId){
        return qualificationRepository.findUserQualificationById(qualificationId, userId).isPresent();
    }









}
