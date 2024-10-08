package com.example.shubham.service.impl;

import com.example.shubham.entity.*;
import com.example.shubham.pojo.OrderPojo;
import com.example.shubham.repository.CartRepository;
import com.example.shubham.repository.ItemRepository;
import com.example.shubham.repository.OrderRepository;
import com.example.shubham.repository.UserRepository;
import com.example.shubham.service.OrderService;
import com.example.shubham.util.ImageToBase64;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    ImageToBase64 imageToBase64 = new ImageToBase64();

    @Transactional
    @Override
    public void saveOrder(OrderPojo orderPojo) {
        Order order=new Order();
        if(orderPojo.getId()!=null){
            order=orderRepository.findById(orderPojo.getId())
                    .orElseThrow(()-> new NoSuchElementException("No data found"));
        }

        order.setDeliveryDate(orderPojo.getDeliveryDate());
        order.setDeliveryTime(orderPojo.getDeliveryTime());
        order.setDeliveryStatus(orderPojo.getDeliveryStatus());
        order.setPaymentStatus(orderPojo.getPaymentStatus());
        Item item=itemRepository.findById(orderPojo.getItemId()).get();
        User user= userRepository.findById(orderPojo.getUserId()).get();
        order.setItem(item);
        order.setUser(user);
        order.setColor(orderPojo.getColor());
        order.setSize(orderPojo.getSize());
        order.setQuantity(orderPojo.getQuantity());

        orderRepository.save(order);

        cartRepository.deleteCartByUserId(orderPojo.getUserId());

    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll().stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/itemImage/" + item.getItem().getItemImage()));
            return item;
        }).collect(Collectors.toList());
    }
    @Override
    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }
    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findByUserId(Integer userId) {
        List<Order> orderList = orderRepository.findByUserId(userId);
        return orderList.stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/itemImage/" + item.getItem().getItemImage()));
            return item;
        }).collect(Collectors.toList());
    }
}
