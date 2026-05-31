package com.wipro.ecommerce.service;

import java.util.List;
import com.wipro.ecommerce.entity.Payment;

public interface PaymentService {

    public Payment addPayment(Payment payment);
    public List<Payment> getAll();
    public String updatePayment(Payment payment);
    public String deletePayment(int id);
    public Object getPaymentById(int id);
    public List<Payment> saveAll(List<Payment> payments);
}