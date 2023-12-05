package com.example.topten.repository;

import com.example.topten.domain.Category;
import com.example.topten.exceptions.DataInvalidException;
import com.example.topten.exceptions.ExceptionsHandler;
import com.example.topten.exceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {

    default Category getCategoryById(String id){
        return get(findById(id).orElse(null),"not found");
    }

    List<Category> findAll();

    private Category get(Category category, String extra){
        if (category == null){
            throw  new ResourceNotFoundException(extra);
        }
        return category;
    }
}
