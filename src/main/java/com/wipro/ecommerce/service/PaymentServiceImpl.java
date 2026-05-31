package com.wipro.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.entity.Payment;
import com.wipro.ecommerce.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository repo;

    public Payment addPayment(Payment payment) {
        return repo.save(payment);
    }

    public List<Payment> getAll() {
        return repo.findAll();
    }

    public String updatePayment(Payment payment) {
        if (payment.getId() == 0) {
            return "ID is required for update";
        }
        Optional<Payment> opt = repo.findById(payment.getId());

        if (opt.isPresent()) {
            repo.save(payment);
            return "Payment updated successfully";
        } else {
            return "No record found with id: " + payment.getId();
        }
    }

    public String deletePayment(int id) {
        Optional<Payment> opt = repo.findById(id);

        if (!opt.isEmpty()) {
            repo.deleteById(id);
            return "Payment successfully deleted";
        }
        return "No record found with id: " + id;
    }

    public Object getPaymentById(int id) {
        Optional<Payment> opt = repo.findById(id);

        if (opt.isPresent()) {
            return opt.get();
        } else {
            return "No record found with id: " + id;
        }
    }

    public List<Payment> saveAll(List<Payment> payments) {
        return repo.saveAll(payments);
    }
}