package com.springboot.chapter4.dao;

import com.springboot.chapter4.pojo.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface MyBatisUserDao {
    public User getUser(Long id);
}
