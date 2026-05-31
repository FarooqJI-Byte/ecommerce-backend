package com.wipro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.ecommerce.entity.Product;
import com.wipro.ecommerce.service.ProductService;

@RestController
@RequestMapping("/ecommerce/products")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(service.addProduct(product));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(service.updateProduct(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteProduct(id));
    }

    @PostMapping("/addAll")
    public ResponseEntity<List<Product>> addAll(@RequestBody List<Product> products) {
        return ResponseEntity.ok(service.saveAll(products));
    }
}
