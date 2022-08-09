package com.xiaowang;

import com.xiaowang.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        List ls = new ArrayList();
        ls.add(1);
        ls.add(0);
        int[] ints = new int[2];


        Map map = new HashMap<>();
        System.out.println(map.get("a"));
    }

    @Test
    public int[] twoSum(int[] nums, int target) {
        Map map = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++){
            map.put(target-nums[i],nums[i]);
        }
        for(int j=0;j<nums.length;j++){
            if(map.get(nums[j])!=null){
                result[0]=nums[j];
                result[1]=Integer.parseInt((String) map.get((Integer)nums[j]));
                return result;
            }
        }
        return null;
    }
    @Test
    public void test1() throws IOException {
        //读取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //或者Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数就是namespace+语句id
        List<User> users = sqlSession.selectList("userMapper.findAll");
        System.out.println(users);
        //释放资源
        sqlSession.close();
        return ;
    }


    @Test
    public void test2() throws IOException {
        //读取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //或者Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数就是namespace+语句id
        User user = new User();
        user.setUsername("tom");
        user.setPassword("abc");
        sqlSession.insert("userMapper.save",user);
        //mybatis 默认事务不提交  执行更新操作需要提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        //读取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //或者Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数就是namespace+语句id
        User user = new User();
        user.setUsername("tommmmmmmmmmm");
        user.setPassword("abcmmmmmm");
        user.setId(1);
        sqlSession.update("userMapper.update",user);
        //mybatis 默认事务不提交  执行更新操作需要提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }


    @Test
    public void test4() throws IOException {
        //读取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //或者Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数就是namespace+语句id
        int id = 1;
        sqlSession.delete("userMapper.del",1);
        //mybatis 默认事务不提交  执行更新操作需要提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
