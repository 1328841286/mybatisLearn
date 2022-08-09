package com.xiaowang.Service.impl;

import com.xiaowang.dao.UserDao;
import com.xiaowang.dao.impl.UserDaoImpl;
import com.xiaowang.domain.User;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl {


    //Test
    public static void main(String[] args) throws IOException {
        UserDao userDao = new UserDaoImpl();
        List<User> all = userDao.findAll();
        System.out.println(all);
    }
}
