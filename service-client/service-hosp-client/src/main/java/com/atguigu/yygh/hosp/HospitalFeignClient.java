package com.atguigu.yygh.hosp;

import com.atguigu.yygh.vo.hosp.ScheduleOrderVo;
import com.atguigu.yygh.vo.order.SignInfoVo;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：m
 * @date ：Created in 2022/5/9 20:38
 */
@FeignClient("service-hosp")
public interface HospitalFeignClient {

    /**
     * 根据排班id获取预约下单数据
     */
    @GetMapping("/api/hosp/hospital/inner/getScheduleOrderVo/{scheduleId}")
    ScheduleOrderVo getScheduleOrderVo(@PathVariable("scheduleId") String scheduleId);

    /**
     * 获取医院签名信息
     */
    @GetMapping("/api/hosp/hospital/inner/getSignInfoVo/{hoscode}")
    public SignInfoVo getSignInfoVo(@PathVariable("hoscode") String hoscode);
}
