package com.atguigu.yygh.hosp.service.impl;



import com.atguigu.yygh.hosp.service.HospitalService;
import com.atguigu.yygh.hosp.service.HospitalSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @author ：m
 * @date ：Created in 2022/4/28 13:00
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalSetService hospitalSetService;

}
