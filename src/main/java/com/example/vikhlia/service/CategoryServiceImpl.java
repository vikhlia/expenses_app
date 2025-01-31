package com.example.vikhlia.service;

import com.example.vikhlia.dao.CategoryRepository;
import com.example.vikhlia.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getCategory(long id) {
        Category category = null;
        Optional<Category> optional = categoryRepository.findById(id);
        if(optional.isPresent())
            category=optional.get();
        return category;
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

//    @Override
//    public int getId(String name) {
//        int id = -1;
//        id = categoryRepository.findByName(name);
//        return id;
//    }
}
