package com.atguigu.yygh.hosp.service;

import com.atguigu.yygh.model.hosp.Hospital;

import java.util.Map;

/**
 * @author ：m
 * @date ：Created in 2022/4/28 12:59
 */
public interface HospitalService{
    //上传医院接口
    void save(Map<String, Object> paramMap);


    //实现根据医院编号查询
    Hospital getByHoscode(String hoscode);
}
