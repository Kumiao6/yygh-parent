package com.atguigu.yygh.user.service;

import com.atguigu.yygh.model.user.UserInfo;
import com.atguigu.yygh.vo.user.LoginVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author ：m
 * @date ：Created in 2022/5/4 23:42
 */
public interface UserInfoService extends IService<UserInfo> {


    //用户手机号登录接口
    Map<String, Object> loginUser(LoginVo loginVo);

    //判断数据库中是否已经存在微信的扫码人信息
    //根据openid判断
    UserInfo selectWxInfoOpenId(String openid);


}
