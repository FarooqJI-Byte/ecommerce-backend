package com.wipro.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ecommerce.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
