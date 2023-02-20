package com.springboot.chapter4.service;

import com.springboot.chapter4.pojo.User;

public interface MyBatisUserService {
    public User getUser(Long id);
}
