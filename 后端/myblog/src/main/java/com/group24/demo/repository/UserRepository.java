package com.group24.demo.repository;

import com.group24.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByAccount(String account);
    @Transactional
    public void deleteByAccount(String account);
}
