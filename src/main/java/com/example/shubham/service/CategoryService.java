package com.example.shubham.service;
import com.example.shubham.entity.Category;
import com.example.shubham.pojo.CategoryPojo;

import java.util.List;
import java.util.Optional;


public interface CategoryService {
    void saveCategory(CategoryPojo categoryPojo);

    List<Category> getAllData();

    Optional<Category> getById(Integer id);

    void deleteById(Integer id);
}
