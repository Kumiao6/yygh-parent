package com.atguigu.msm.service;

/**
 * @author ：m
 * @date ：Created in 2022/5/5 13:50
 */
public interface MsmService {

    //发送手机验证码
    boolean send(String phone, String code);
}
