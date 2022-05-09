package com.atguigu.yygh.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：m
 * @date ：Created in 2022/5/9 10:53
 */
@Configuration
@MapperScan("com.atguigu.yygh.order.mapper")
public class OrderConfig {
}
