package com.wipro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.ecommerce.entity.Orders;
import com.wipro.ecommerce.service.OrderService;

@RestController
@RequestMapping("/ecommerce/orders")
public class OrderController {

	@Autowired
	OrderService service;

	@PostMapping("/add")
	public Orders addOrder(@RequestBody Orders order) {
		return service.addOrder(order);
	}

	@GetMapping("/getall")
	public List<Orders> getAll() {
		return service.getAll();
	}

	@GetMapping("/get/{id}")
	public Orders getOrderById(@PathVariable int id) {
		return service.getOrderById(id);
	}

	@PutMapping("/update")
	public String updateOrder(@RequestBody Orders order) {
		return service.updateOrder(order);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOrder(@PathVariable int id) {
		return service.deleteOrder(id);
	}

	@PostMapping("/addAll")
	public List<Orders> addAll(@RequestBody List<Orders> orders) {
		return service.saveAll(orders);
	}

}