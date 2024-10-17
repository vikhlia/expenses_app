package com.example.vikhlia.dao;

import com.example.vikhlia.entity.Category;
import com.example.vikhlia.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
