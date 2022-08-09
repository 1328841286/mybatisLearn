package com.xiaowang.dao;

import com.xiaowang.domain.User;
import com.xiaowang.domain.User1;

import java.io.IOException;
import java.util.List;

public interface User1Dao {
     List<User1> findAll() throws IOException;

     User1 findById(int id);

     User1 findOne(User1 user);

     void save(User1 user1);
}
