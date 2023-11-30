package com.example.topten.service;

import com.example.topten.domain.Category;
import com.example.topten.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category findCategoryById(String id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<Category> findCategory(){
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        category.setId(UUID.randomUUID().toString());
        return categoryRepository.save(category);
    }

    public void deleteCategory(String id){
        categoryRepository.deleteById(id);
    }
}
