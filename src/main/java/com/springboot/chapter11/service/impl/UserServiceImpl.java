package com.springboot.chapter11.service.impl;

import com.springboot.chapter11.dao.UserDao;
import com.springboot.chapter11.pojo.User;
import com.springboot.chapter11.service.UserService;
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
    public List<User> findUsers(String userName, String note, int start, int limit) {
        return null;
    }

    @Override
    public int updateUserName(Long id, String userName) {
        return userDao.updateUserName(id,userName);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}
