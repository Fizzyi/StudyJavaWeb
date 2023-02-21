package com.springboot.chapter10.service;

import com.springboot.chapter10.pojo.User;

import java.util.List;

public interface UserService {
    //获取用户信息
    public User getUser(Long id);
    //新增用户
    public int insertUser(User user);

    public List<User> findUsers(String userName, String note);
}
