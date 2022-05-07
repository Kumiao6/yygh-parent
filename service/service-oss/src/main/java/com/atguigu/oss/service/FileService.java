package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：m
 * @date ：Created in 2022/5/7 21:55
 */
public interface FileService {

    //上传文件到阿里云oss
    String upload(MultipartFile file);

}
