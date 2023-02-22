package com.springboot.chapter11.dao;

import com.springboot.chapter11.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User getUser(Long id);

    int insertUser(User user);

    List<User> findUsers(String userName,String note);

    int updateUser(User user);

    int updateUserName(Long id,String userName);

    int deleteUser(Long id);
}