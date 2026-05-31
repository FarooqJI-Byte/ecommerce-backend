package com.wipro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.ecommerce.entity.Category;
import com.wipro.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/ecommerce/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(service.addCategory(category));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCategory(@RequestBody Category category) {
        return ResponseEntity.ok(service.updateCategory(category));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteCategory(id));
    }

    @PostMapping("/addAll")
    public ResponseEntity<List<Category>> addAll(@RequestBody List<Category> categories) {
        return ResponseEntity.ok(service.saveAll(categories));
    }
}