package com.example.mongo;

import com.example.mongo.entity.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.regex.Pattern;

@SpringBootTest
class MongoApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    void contextLoads() {

    }

    //添加
    @Test
    public void createUser() {
        User user = new User();
        user.setAge(11100);
        user.setName("test");
        user.setEmail("4932200@qq.com");
        User user1 = mongoTemplate.insert(user);
        System.out.println(user1);
    }

    //修改
    @Test
    public void update() {
        //根据id查询
        User user = mongoTemplate.findById("62695353b5fcee152c43f571", User.class);


        //设置修改值
        user.setName("tttttt_1");
        user.setAge(12343);
        user.setCreateDate("xxx");
        user.setEmail("asdfafx");



        //etym方法实现 修改
        Query query = new Query(Criteria.where("_id").is(user.getId()));
        Update update = new Update();
        update.set("name", user.getName());
        update.set("age", user.getAge());
        update.set("email", user.getEmail());
        UpdateResult upsert = mongoTemplate.upsert(query, update, User.class);
        long matchedCount = upsert.getMatchedCount();
        System.out.println(matchedCount);
        System.out.println(user);
    }

    //删除操作
    @Test
    public void delete() {
        Query query =
                new Query(Criteria.where("_id").is("62695353b5fcee152c43f571"));
        DeleteResult result = mongoTemplate.remove(query, User.class);
        long deletedCount = result.getDeletedCount();
        System.out.println(deletedCount);

    }
}
