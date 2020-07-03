package com.group24.demo.repository;
import com.group24.demo.entity.Blog;
import com.group24.demo.entity.Follower;
import com.group24.demo.entity.Subscriber;
import com.group24.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private FollowerRepository followerRepository;
    @Autowired
    private SubscriberRepository subscriberRepository;
    //读取数据库中
 /* @Test
    void findAll()
    {  System.out.println(userRepository.findByAccount("shengziwei").getPassword());
       if(userRepository.findByAccount("shengziwie")==null);
       System.out.println("fail");
       //System.out.println(userRepository.findById(1));
        //System.out.println(userRepository.findAll().get(0).getAccount());
    }
    //保存到数据库*/
 /*

    @Test
    void updata(){
        User user=userRepository.findByAccount("微");
        user.setAccount("shengziwei");
        user.setPassword("123456");
        user.setTime(new Date());
        userRepository.save(userRepository.findByAccount("微"));

    }*/
    @Test
    void save(){
        User user=new User();
        user.setAccount("szw");
        user.setPassword("1234567");
        user.setTime(new Date());
        user.setEmail("123456@qq.com");
        user.setName("子微");
        user.setSex("male");

        List<Blog> myblog=blogRepository.findByArticleUserAccount("szw");

        for (int i=0;i<myblog.size();i++){
            user.getBlogs().add(myblog.get(i));
            System.out.println(user.getBlogs().get(i).getArticleTitle());

        }
        Follower follower=new Follower();
        follower.setFollowerAccount("shengziwei");
        follower.setFollowerUser(userRepository.findByAccount("szw"));
        followerRepository.save(follower);
        user.getFollowers().add(follower);
        Subscriber subscriber=new Subscriber();
        subscriber.setSubscriberAccount("szw");
        subscriber.setSubscriberUser(userRepository.findByAccount("shengziwei"));
        subscriberRepository.save(subscriber);
        user.getSubscribers().add(subscriber);
        User user1=userRepository.save(user);
        Optional<User> user2= Optional.ofNullable(userRepository.findByAccount("szw"));
        User user3=user2.get();
        System.out.println(user3.getAccount());
        System.out.println(user3.getAccount());
        System.out.println(user3.getAccount());
        System.out.println(user3.getBlogs());
        for (int i=0;i<user3.getBlogs().size();i++)
            System.out.println(user3.getBlogs().get(i).getArticleTitle());
    }
   @Test
   public void delete(){
        User user=new User();
        user.setAccount("szw");
        user.setPassword("1234567");
        user.setTime(new Date());
        User user1=userRepository.save(user);
     userRepository.deleteByAccount("微");
    }
}
