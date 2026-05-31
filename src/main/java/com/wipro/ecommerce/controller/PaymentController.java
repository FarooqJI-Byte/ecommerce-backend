package com.wipro.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wipro.ecommerce.entity.Payment;
import com.wipro.ecommerce.service.PaymentService;

@RestController
@RequestMapping("/ecommerce/payment")
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping("/add")
    public Payment addPayment(@RequestBody Payment payment) {
        return service.addPayment(payment);
    }

    @PostMapping("/addAll")
    public List<Payment> addAll(@RequestBody List<Payment> payments) {
        return service.saveAll(payments);
    }

    @GetMapping("/getall")
    public List<Payment> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Object getPaymentById(@PathVariable int id) {
        return service.getPaymentById(id);
    }

    @PutMapping("/update")
    public String updatePayment(@RequestBody Payment payment) {
        return service.updatePayment(payment);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable int id) {
        return service.deletePayment(id);
    }
}
