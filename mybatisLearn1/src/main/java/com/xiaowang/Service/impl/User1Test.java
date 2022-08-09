package com.xiaowang.Service.impl;

import com.xiaowang.dao.User1Dao;
import com.xiaowang.dao.UserDao;
import com.xiaowang.domain.User1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class User1Test {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        User1Dao mapper = sqlSession.getMapper(User1Dao.class);

        User1 user1 = new User1();
        user1.setUsername("99999999999999");
        user1.setPassword("00000000000000");
        user1.setBirthday(new Date());
        mapper.save(user1);
        sqlSession.commit();
    }
}
