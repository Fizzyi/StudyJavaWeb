package com.springboot.chapter4.service.impl;

import com.springboot.chapter4.dao.MyBatisUserDao;
import com.springboot.chapter4.pojo.User;
import com.springboot.chapter4.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {
    @Autowired
    private MyBatisUserDao myBatisUserDao;

    @Override
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }
}
