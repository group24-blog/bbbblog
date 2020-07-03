package com.group24.demo.repository;

import com.group24.demo.entity.Blog;
import com.group24.demo.entity.Follower;
import com.group24.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class FollowerRepositoryTest {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FollowerRepository followerRepository;

    @Test
    void save(){
        Follower follower=new Follower();
        follower.setFollowerAccount("szw");
        follower.setFollowerUser(userRepository.findByAccount("shengziwei"));
        followerRepository.save(follower);

    }

}
