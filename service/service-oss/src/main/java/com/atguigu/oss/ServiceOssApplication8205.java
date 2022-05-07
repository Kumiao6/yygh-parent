package com.atguigu.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：m
 * @date ：Created in 2022/5/7 20:41
 */
@ComponentScan(basePackages = {"com.atguigu"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class ServiceOssApplication8205 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOssApplication8205.class, args);
    }
}
