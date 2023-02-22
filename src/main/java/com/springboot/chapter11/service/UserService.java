package com.springboot.chapter11.service;

import com.springboot.chapter11.pojo.User;

import java.util.List;

public interface UserService {
    //获取用户信息
    public User getUser(Long id);
    //新增用户
    public int insertUser(User user);

    public List<User> findUsers(String userName, String note,int start,int limit);

    //修改用户
    public void updateUser(User user);

    //通过ID修改用户名
    public int updateUserName(Long id,String userName);

    //通过ID删除数据
    public int deleteUser(Long id);
}
