package com.wipro.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.entity.Product;
import com.wipro.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repo;

	public Product addProduct(Product product) {
		return repo.save(product);
	}

	public List<Product> getAll() {
		return repo.findAll();
	}

	public String updateProduct(Product product) {
		if (product.getId() == 0) {
			return "ID is required for update";
		}
		Optional<Product> opt = repo.findById(product.getId());

		if (opt.isPresent()) {
			repo.save(product);
			return "Product updated successfully";
		} else {
			return "No record found with id: " + product.getId();
		}
	}

	public String deleteProduct(int id) {
		Optional<Product> opt = repo.findById(id);
		if (!opt.isEmpty()) {
			repo.deleteById(id);
			return "Product successfully deleted";
		}
		return "No record found with id: " + id;
	}

	public Product getProductById(int id) {
		Optional<Product> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public List<Product> saveAll(List<Product> products) {
		return repo.saveAll(products);
	}
}