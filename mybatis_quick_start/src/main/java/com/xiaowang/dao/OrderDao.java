package com.xiaowang.dao;

import com.xiaowang.domain.Order;

import java.util.List;

public interface OrderDao {

    List<Order> findAll();
}
