package com.wipro.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.ecommerce.entity.Payment;
import com.wipro.ecommerce.service.PaymentService;

@RestController
@RequestMapping("/ecommerce/payment")
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping("/add")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(service.addPayment(payment));
    }

    @PostMapping("/addAll")
    public ResponseEntity<List<Payment>> addAll(@RequestBody List<Payment> payments) {
        return ResponseEntity.ok(service.saveAll(payments));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Payment>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPaymentById(@PathVariable int id) {
        return ResponseEntity.ok(service.getPaymentById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(service.updatePayment(payment));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable int id) {
        return ResponseEntity.ok(service.deletePayment(id));
    }
}