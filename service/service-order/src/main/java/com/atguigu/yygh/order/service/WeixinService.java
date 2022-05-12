package com.atguigu.yygh.order.service;

import java.util.Map;

/**
 * @author ：m
 * @date ：Created in 2022/5/12 16:42
 */
public interface WeixinService {

    //生成微信支付二维码
    Map createNative(Long orderId);

    //调用微信接口实现支付状态查询
    Map<String, String> queryPayStatus(Long orderId);
}
