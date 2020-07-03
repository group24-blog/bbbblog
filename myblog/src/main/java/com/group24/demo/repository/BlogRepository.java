package com.group24.demo.repository;

import com.group24.demo.entity.Blog;
import com.group24.demo.entity.Comment;
import com.group24.demo.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    public List<Blog> findByArticleUserAccount(String account);
    public Blog findByArticleId(int id);
    public List<Blog> findByArticleTitle(String articleTitle);



}
