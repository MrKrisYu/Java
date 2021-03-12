package com.krisyu.service.impl;

import com.krisyu.dao.UserDao;
import com.krisyu.dao.impl.UserDapImpl;
import com.krisyu.entity.User;
import com.krisyu.service.UserService;

/**
 * @Author: Kris
 * @Date: 2021/3/12 - 03 - 12 - 16:57
 * @Description: com.krisyu.service.impl
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDapImpl();

    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }
}
