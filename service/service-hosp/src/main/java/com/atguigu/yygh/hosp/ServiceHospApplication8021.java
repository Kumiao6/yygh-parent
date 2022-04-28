package com.atguigu.yygh.hosp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.atguigu")
public class ServiceHospApplication8021 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication8021.class, args);
    }
}
