package com.group24.demo.repository;

import com.group24.demo.entity.Blog;
import com.group24.demo.entity.Comment;
import com.group24.demo.entity.Follower;
import com.group24.demo.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowerRepository extends JpaRepository<Follower,Integer> {
    public List<Follower> findByFollowerUserAccount(String account);



}