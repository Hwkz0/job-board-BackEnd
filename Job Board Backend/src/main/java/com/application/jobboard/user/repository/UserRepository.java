package com.application.jobboard.user.repository;

import com.application.jobboard.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import  java.util.Optional;

@Mapper
@Repository
public interface UserRepository {

    void addUser(User user);

    Optional<User> findByEmail(String userEmail);

    User findByUserId(long userId);

    void updateUser(User user);

}
