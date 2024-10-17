package com.example.vikhlia.service;

import com.example.vikhlia.entity.Category;
import com.example.vikhlia.entity.Transaction;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();

    public void saveCategory(Category category);

    public Category getCategory(long id);

    public void deleteCategory(long id);

//    public int getId(String name);
}
