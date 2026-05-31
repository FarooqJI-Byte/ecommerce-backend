package com.wipro.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.entity.Category;
import com.wipro.ecommerce.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository repo;

	public Category addCategory(Category category) {
		return repo.save(category);
	}

	public List<Category> getAll() {
		return repo.findAll();
	}

	public String updateCategory(Category category) {
		if (category.getId() == 0) {
			return "ID is required for update";
		}
		Optional<Category> opt = repo.findById(category.getId());

		if (opt.isPresent()) {
			repo.save(category);
			return "Category updated successfully";
		} else {
			return "No record found with id: " + category.getId();
		}
	}

	public String deleteCategory(int id) {
		Optional<Category> opt = repo.findById(id);
		if (!opt.isEmpty()) {
			repo.deleteById(id);
			return "Category successfully deleted";
		}
		return "No record found with id: " + id;
	}

	public Category getCategoryById(int id) {
		Optional<Category> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public List<Category> saveAll(List<Category> categories) {
		return repo.saveAll(categories);
	}

}