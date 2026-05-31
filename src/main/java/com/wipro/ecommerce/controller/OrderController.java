package com.wipro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.ecommerce.entity.Orders;
import com.wipro.ecommerce.service.OrderService;

@RestController
@RequestMapping("/ecommerce/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping("/add")
    public ResponseEntity<Orders> addOrder(@RequestBody Orders order) {
        return ResponseEntity.ok(service.addOrder(order));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Orders>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable int id) {
        return ResponseEntity.ok(service.getOrderById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateOrder(@RequestBody Orders order) {
        return ResponseEntity.ok(service.updateOrder(order));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteOrder(id));
    }

    @PostMapping("/addAll")
    public ResponseEntity<List<Orders>> addAll(@RequestBody List<Orders> orders) {
        return ResponseEntity.ok(service.saveAll(orders));
    }
}