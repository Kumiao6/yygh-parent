package com.example.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ：m
 * @date ：Created in 2022/4/27 22:34
 */
@Data
@Document("User")
public class User {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;
    private String createDate;
}
