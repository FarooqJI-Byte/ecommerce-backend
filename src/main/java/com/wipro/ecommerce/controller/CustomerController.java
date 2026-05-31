package com.wipro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.ecommerce.entity.Customer;
import com.wipro.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/ecommerce/customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.addCustomer(customer));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.updateCustomer(customer));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteCustomerById(id));
    }

    @PostMapping("/addAll")
    public ResponseEntity<List<Customer>> addAll(@RequestBody List<Customer> customers) {
        return ResponseEntity.ok(service.saveAll(customers));
    }
}