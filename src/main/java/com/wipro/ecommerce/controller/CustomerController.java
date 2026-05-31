package com.wipro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.ecommerce.entity.Customer;
import com.wipro.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/ecommerce/customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}

	@GetMapping("/getall")
	public List<Customer> getAll() {
		return service.getAll();
	}

	@GetMapping("/get/{id}")
	public Object getCustomerById(@PathVariable int id) {
		return service.getCustomerById(id);

	}

	@PutMapping("/update")
	public String updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id) {
		return service.deleteCustomerById(id);
	}

	@PostMapping("/addAll")
	public List<Customer> addAll(@RequestBody List<Customer> customers) {
		return service.saveAll(customers);
	}

}