package com.xiaowang.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.List;

public class User1Test {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        User1Dao mapper = sqlSession.getMapper(User1Dao.class);

        User1 user1 = new User1();
        user1.setUsername("9999999");
        user1.setPassword("0000000");
        user1.setBirthday(new Date());
        mapper.save(user1);
        sqlSession.commit();

        List<User1> all = mapper.findAll();
        User1 user11 = all.get(0);
        System.out.println("-----------------------------");

        //设置分页参数  当前页  每页显示条数
        PageHelper.startPage(1,3);
        List<User1> all11 = mapper.findAll();
        for (User1 user12 : all11) {
            System.out.println(user12);
        }


        System.out.println("-----------------------");
        //获取分页相关参数,如当前页，上一页，下一页，每页显示条数等。。。
        PageInfo<User1> user1PageInfo = new PageInfo<User1>(all11);
        System.out.println("当前页："+user1PageInfo.getPageNum());
        System.out.println("每页显示条数"+user1PageInfo.getPageSize());
        System.out.println("总条数"+user1PageInfo.getTotal());
        System.out.println("总页数"+user1PageInfo.getPages());
        //......


    }
}
