package com.application.jobboard.address.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AddressRepository {

    String findAddressByUserId(Long userId);

}
