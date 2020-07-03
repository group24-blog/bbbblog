package com.group24.demo.repository;

import com.group24.demo.entity.Blog;
import com.group24.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BlogRepositoryTest {
    @Autowired
 private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;
 @Test
    public void save()
 {
     User user=userRepository.findByAccount("szw");
     Blog blog=new Blog();
     blog.setArticleUser(user);
     blog.setArticleTitle("good");
     blog.setArticleTime(new Date());
     //System.out.println(blog);
     blogRepository.save(blog);
 }
 @Test
    public void findBlog(){
     List<Blog> blogList=new ArrayList<Blog>();
     blogList=blogRepository.findByArticleUserAccount("szw");
     for (int i=0;i<blogList.size();i++) {
         System.out.println(blogList.get(i).getArticleTime());
         System.out.println(blogList.get(i).getArticleUser().getAccount());
         System.out.println(blogList.get(i).getArticleId());
         System.out.println(blogList.get(i).getArticleTitle());
         System.out.println(blogList.get(i).getArticleContent());
     }
     }
}
