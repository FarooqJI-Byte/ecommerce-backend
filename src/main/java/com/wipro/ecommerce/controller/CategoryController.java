package com.wipro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.ecommerce.entity.Category;
import com.wipro.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/ecommerce/category")
public class CategoryController {

	@Autowired
	CategoryService service;

	@PostMapping("/add")
	public Category addCategory(@RequestBody Category category) {
		return service.addCategory(category);
	}

	@GetMapping("/getall")
	public List<Category> getAll() {
		return service.getAll();
	}

	@GetMapping("/get/{id}")
	public Category getCategoryById(@PathVariable int id) {
		return service.getCategoryById(id);
	}

	@PutMapping("/update")
	public String updateCategory(@RequestBody Category category) {
		return service.updateCategory(category);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCategory(@PathVariable int id) {
		return service.deleteCategory(id);
	}

	@PostMapping("/addAll")
	public List<Category> addAll(@RequestBody List<Category> categories) {
		return service.saveAll(categories);
	}

}