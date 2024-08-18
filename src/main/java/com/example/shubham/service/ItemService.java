package com.example.shubham.service;

import com.example.shubham.entity.Item;
import com.example.shubham.pojo.ItemPojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    void saveItem(ItemPojo itemPojo) throws IOException;

    List<Item> findAll();

    Optional<Item> findById(Integer id);

    void deleteById(Integer id);
    List<Item> searchByName(String itemName);

    List<Item> getItemsByBrandName(String brandName);

    List<Item> getItemsByCategoryName(String categoryName);
}
