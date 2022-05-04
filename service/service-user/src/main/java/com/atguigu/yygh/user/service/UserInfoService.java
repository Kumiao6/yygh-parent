package com.atguigu.yygh.user.service;

import com.atguigu.yygh.vo.user.LoginVo;

import java.util.Map;

/**
 * @author ：m
 * @date ：Created in 2022/5/4 23:42
 */
public interface UserInfoService {


    //用户手机号登录接口
    Map<String, Object> loginUser(LoginVo loginVo);

}
