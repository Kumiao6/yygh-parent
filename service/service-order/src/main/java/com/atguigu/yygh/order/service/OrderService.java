package com.atguigu.yygh.order.service;

import com.atguigu.yygh.model.order.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author ：m
 * @date ：Created in 2022/5/9 10:47
 */
public interface OrderService extends IService<OrderInfo> {

    //生成挂号订单
    Long saveOrder(String scheduleId, Long patientId);
}
