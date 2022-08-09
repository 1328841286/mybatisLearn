package com.xiaowang.dao;

import com.xiaowang.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
     List<User> findAll() throws IOException;

     User findById(int id);

     User findOne(User user);
}
