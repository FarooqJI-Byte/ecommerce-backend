package com.wipro.ecommerce.service;

import java.util.List;

import com.wipro.ecommerce.entity.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public List<Product> getAll();

	public String updateProduct(Product product);

	public String deleteProduct(int id);

	public Product getProductById(int id);

	public List<Product> saveAll(List<Product> products);

}
