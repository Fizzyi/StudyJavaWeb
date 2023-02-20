package com.springboot.chapter4.service;

import com.springboot.chapter4.pojo.User;

import java.util.List;

public interface UserBatchService {
    public int insertUsers(List<User> userList);
}
