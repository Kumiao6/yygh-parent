package com.atguigu.yygh.user.client;

import com.atguigu.yygh.model.user.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：m
 * @date ：Created in 2022/5/9 11:44
 */
@FeignClient(value = "service-user")
@Repository
public interface PatientFeignClient {

    //根据就诊人id获取就诊人信息
    @GetMapping("/api/user/patient/inner/get/{id}")
    public Patient getPatientOrder(@PathVariable("id") Long id);
}
