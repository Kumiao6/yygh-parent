package com.example.mongo.repository;

import com.example.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：m
 * @date ：Created in 2022/4/28 08:05
 */
@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
