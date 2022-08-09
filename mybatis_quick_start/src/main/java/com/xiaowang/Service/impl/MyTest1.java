package com.xiaowang.Service.impl;

import com.xiaowang.dao.UserDao;
import com.xiaowang.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis 动态代理实现代理
 */
public class MyTest1 {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.findAll();
        System.out.println(all);

        System.out.println("--------------------");
        User byId = mapper.findById(2);
        System.out.println(byId);


        System.out.println("---------------");
        //多条件查询
        User user = new User();
        user.setId(6);
        user.setUsername("999");
        User one = mapper.findOne(user);
        System.out.println("findOne:"+one);
    }
}
