package com.springboot.chapter10.dao;

import com.springboot.chapter10.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User getUser(Long id);

    int insertUser(User user);

    List<User> findUsers(String userName,String note);
}