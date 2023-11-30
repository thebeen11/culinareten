package com.example.topten.controller;

import com.example.topten.domain.Category;
import com.example.topten.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findCategory(){
        List<Category> categories = categoryService.findCategory();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable String id){

        Category category = categoryService.findCategoryById(id);

        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category reqCategory){

        Category category = categoryService.saveCategory(reqCategory);

        return  ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCatgeory(@PathVariable String id){
        categoryService.deleteCategory(id);
    }
}
