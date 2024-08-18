package com.example.shubham.service;


import com.example.shubham.entity.Order;

import com.example.shubham.pojo.OrderPojo;
import java.util.List;
import java.util.Optional;

public interface OrderService {

        void saveOrder(OrderPojo orderPojo);

        List<Order> findAll();
        List<Order> findByUserId(Integer userId);
        Optional<Order> findById(Integer id);

        void deleteById(Integer id);



    }


