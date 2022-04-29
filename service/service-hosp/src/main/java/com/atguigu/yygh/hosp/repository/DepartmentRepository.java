package com.atguigu.yygh.hosp.repository;

import com.atguigu.yygh.model.hosp.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：m
 * @date ：Created in 2022/4/28 22:36
 */
@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
    //判断是否存在getHospitalByHoscode
    Department getDepartmentByHoscodeAndDepcode(String hoscode, String depcode);


}
