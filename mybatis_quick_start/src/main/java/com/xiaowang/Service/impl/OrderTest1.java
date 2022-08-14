package com.xiaowang.Service.impl;

import com.xiaowang.dao.OrderDao;
import com.xiaowang.dao.User1Dao;
import com.xiaowang.domain.Order;
import com.xiaowang.domain.User1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 在那时注释掉 Date Handle 中3个方法 使用默认空实现方法
 */
public class OrderTest1 {
    @Test
    public static   void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        OrderDao mapper = sqlSession.getMapper(OrderDao.class);
        List<Order> all = mapper.findAll();
        for (Order order : all) {
            System.out.println(order);
            System.out.println(order.getUser1().getUsername());
        }
        System.out.println("-------------------------------------");
        System.out.println("一对多：");
        oneToMany();
    }


    /**
     * 一对多 一个用户多个订单
     */
    public static void oneToMany() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        User1Dao mapper1 = sqlSession.getMapper(User1Dao.class);
        List<User1> allAndOrders = mapper1.findAllAndOrders();
        for (User1 allAndOrder : allAndOrders) {
            System.out.println(allAndOrder.toString());
        }
    }
}
