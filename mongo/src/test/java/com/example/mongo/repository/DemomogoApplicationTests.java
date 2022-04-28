package com.example.mongo.repository;

import com.example.mongo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.TestExecutionListeners;

import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/28 08:06
 */
@SpringBootTest
public class DemomogoApplicationTests {
    @Autowired
    private UserRepository userRepository;

    //添加
    @Test
    public void createUser() {
        User user = new User();
        user.setAge(20);
        user.setName("张三");
        user.setEmail("3332200@qq.com");
        User user1 = userRepository.save(user);
    }

    //查询所有
    @Test
    public void finUser() {
        List<User> all = userRepository.findAll();
        System.out.println(all);
    }

    //id查询
    @Test
    public void getById() {
        User user = userRepository.findById("6269527b4475800905c5b1e5").get();
        System.out.println(user);
    }

    //条件查询
    @Test
    public void findUserList() {
        User user = new User();
        user.setName("test");
//        user.setAge(20);
        Example<User> userExample = Example.of(user);
        List<User> userList = userRepository.findAll(userExample);
        System.out.println(userList);
    }

    //模糊查询
    @Test
    public void findUserLikeName() {
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching()//构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)//改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true);//改变默认大小写忽略方式；忽略大小写
        User user = new User();
        user.setName("est");


        Example<User> userExample = Example.of(user,matcher);
        List<User> list = userRepository.findAll(userExample);
        System.out.println(list);
    }

    //分布查询
    @Test
    public void finUserPage() {
        Sort sort = Sort.by(Sort.Direction.DESC, "age");
        //0为第一页
        PageRequest pageable = PageRequest.of(0, 10, sort);



        ExampleMatcher matcher = ExampleMatcher.matching()//构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)//改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true);//改变默认大小写忽略方式；忽略大小写
        User user = new User();
        user.setName("est");
        Example<User> example = Example.of(user,matcher);


        Page<User> page = userRepository.findAll(example, pageable);
        System.out.println(page);
        System.out.println(page.get());

    }

    //修改
    @Test
    public void updateUser() {
        User user = userRepository.findById("6269527b4475800905c5b1e5").get();
        user.setName("testtest");
        user.setEmail("222@qq.com");

        User updateUsers = userRepository.save(user);
        System.out.println(updateUsers);
    }

    //删除
    @Test
    public void removeUser() {
        User user = userRepository.findById("6269527b4475800905c5b1e5").get();

        userRepository.deleteById("6269527b4475800905c5b1e5");

    }
}
