package com.wipro.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.ecommerce.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
