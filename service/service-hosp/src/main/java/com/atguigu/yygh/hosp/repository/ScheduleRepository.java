package com.atguigu.yygh.hosp.repository;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.atguigu.yygh.model.hosp.Hospital;
import com.atguigu.yygh.model.hosp.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：m
 * @date ：Created in 2022/4/29 15:42
 */
@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {

    // 根据医院编号 和 科室编号查询
    Schedule getScheduleByHoscodeAndHosScheduleId(String hoscode, String hosScheduleId);

    //查询科室接口

}

