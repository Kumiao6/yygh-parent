package com.atguigu.yygh.hosp.controller.api;


import com.atguigu.yygh.hosp.service.HospitalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：m
 * @date ：Created in 2022/4/28 13:04
 */
@RestController
@Repository
@Api(tags = "医院管理API接口")
@RequestMapping("/api/hosp")
public class ApiController {
    @Autowired
    private HospitalService hospitalService;
}
