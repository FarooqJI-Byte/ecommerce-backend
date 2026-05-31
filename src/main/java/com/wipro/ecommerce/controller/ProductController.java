package com.wipro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.ecommerce.entity.Product;
import com.wipro.ecommerce.service.ProductService;

@RestController
@RequestMapping("/ecommerce/products")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@GetMapping("/getall")
	public List<Product> getAll() {
		return service.getAll();
	}

	@GetMapping("/get/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProductById(id);
	}

	@PutMapping("/update")
	public String updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

	@PostMapping("/addAll")
	public List<Product> addAll(@RequestBody List<Product> products) {
		return service.saveAll(products);
	}
}