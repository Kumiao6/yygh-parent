package com.atguigu.yygh.hosp.service.impl;



import com.alibaba.fastjson.JSONObject;
import com.atguigu.yygh.hosp.repository.HospitalRepository;
import com.atguigu.yygh.hosp.service.HospitalService;
import com.atguigu.yygh.hosp.service.HospitalSetService;
import com.atguigu.yygh.model.hosp.Hospital;
import com.atguigu.yygh.vo.hosp.HospitalQueryVo;
import com.fasterxml.jackson.databind.JsonNode;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

/**
 * @author ：m
 * @date ：Created in 2022/4/28 13:00
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;




    @Override
    public void save(Map<String, Object> paramMap) {
        //把参数map集合转换对象 Hospital
        String mapString = JSONObject.toJSONString(paramMap);
        Hospital hospital = JSONObject.parseObject(mapString, Hospital.class);

        //判断是否存在数据
        String hoscode = hospital.getHoscode();
        Hospital hospitalExist = hospitalRepository.getHospitalByHoscode(hoscode);

        //如果存在，进行修改
        if(hospitalExist != null) {
            hospital.setStatus(hospitalExist.getStatus());
            hospital.setCreateTime(hospitalExist.getCreateTime());
            hospital.setUpdateTime(new Date());
            hospital.setIsDeleted(0);
            hospitalRepository.save(hospital);
        } else {//如果不存在，进行添加
            hospital.setStatus(0);
            hospital.setCreateTime(new Date());
            hospital.setUpdateTime(new Date());
            hospital.setIsDeleted(0);
            hospitalRepository.save(hospital);
        }
    }

    @Override
    public Hospital getByHoscode(String hoscode) {
        Hospital hospital = hospitalRepository.getHospitalByHoscode(hoscode);
        return hospital;
    }

    /**
     *
     * @param page
     * @param limit
     * @param hospitalQueryVo
     * @return
     */
    @Override
    public Page<Hospital> selectHospPage(Integer page, Integer limit, HospitalQueryVo hospitalQueryVo) {
        //创建pageable对象
        Pageable pageable = PageRequest.of(limit - 0, limit);
        //创建条件匹配器
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase(true);

        //hospitalSetQueryVo转换Hospital对象
        Hospital hospital = new Hospital();
        BeanUtils.copyProperties(hospitalQueryVo,hospital);

        //创建对象
        Example<Hospital> example = Example.of(hospital,matcher);

        //调用方法实现查询
        Page<Hospital> all = hospitalRepository.findAll(example, pageable);

        return all;
    }


}

