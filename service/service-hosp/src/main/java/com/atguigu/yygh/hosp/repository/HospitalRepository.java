package com.atguigu.yygh.hosp.repository;

import com.atguigu.yygh.model.hosp.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：m
 * @date ：Created in 2022/4/28 12:56
 */
@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {

}
