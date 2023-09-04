package com.application.jobboard.qualifications.repository;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

import com.application.jobboard.qualifications.domain.UserQualification;
import com.application.jobboard.qualifications.domain.Qualification;

import java.util.List;
import java.util.Optional;


@Mapper
@Repository
public interface QualificationRepository {

    List<Qualification> getAllQualifications();

    Optional<Qualification> findQualificationById(Long qualificationId);

    Optional<UserQualification> findUserQualificationById(Long userQualificationId, long userId);

    void addUserQualification(UserQualification userQualification);

}
