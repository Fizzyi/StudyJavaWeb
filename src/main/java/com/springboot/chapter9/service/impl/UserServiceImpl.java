package com.springboot.chapter9.service.impl;

import com.springboot.chapter9.dao.UserDao;
import com.springboot.chapter9.pojo.User;
import com.springboot.chapter9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW, timeout = 1)
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public List<User> findUsers(String userName,String note){
        return userDao.findUsers(userName,note);
    }
}
