package com.wipro.ecommerce.service;

import java.util.List;
import com.wipro.ecommerce.entity.Category;

public interface CategoryService {

	public Category addCategory(Category category);

	public List<Category> getAll();

	public String updateCategory(Category category);

	public String deleteCategory(int id);

	public Category getCategoryById(int id);

	public List<Category> saveAll(List<Category> categories);
}