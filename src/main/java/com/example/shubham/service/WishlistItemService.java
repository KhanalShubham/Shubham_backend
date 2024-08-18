package com.example.shubham.service;

import com.example.shubham.entity.WishlistItem;
import com.example.shubham.pojo.WishlistItemPojo;
import java.util.List;
import java.util.Optional;

public interface WishlistItemService {

    void saveWishlistItem(WishlistItemPojo wishlistItemPojo);

    List<WishlistItem> findAll();


    Optional<WishlistItem> findById(Integer id);

    List<WishlistItem> findByUserId(Integer userId);


    void deleteById(Integer id);
}


