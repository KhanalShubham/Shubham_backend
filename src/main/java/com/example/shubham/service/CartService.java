package com.example.shubham.service;


import com.example.shubham.entity.Cart;
import com.example.shubham.pojo.CartPojo;

import java.util.List;
import java.util.Optional;

public interface CartService {

    void saveCart(CartPojo cartPojo);

    List<Cart> findAll();

    Optional<Cart> findById(Integer id);

    void deleteById(Integer id);

    List<Cart> findByUserId(Integer userId);

}


