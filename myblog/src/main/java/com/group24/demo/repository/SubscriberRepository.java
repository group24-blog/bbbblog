package com.group24.demo.repository;

import com.group24.demo.entity.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriberRepository extends JpaRepository<Subscriber,Integer> {
    public List<Subscriber> findBySubscriberUserAccount(String account);



}