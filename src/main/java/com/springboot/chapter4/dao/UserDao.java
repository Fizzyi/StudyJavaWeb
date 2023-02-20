package com.springboot.chapter4.dao;

import com.springboot.chapter4.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUser(Long id);

    int insertUser(User user);
}