package com.wipro.ecommerce.service;

import java.util.List;

import com.wipro.ecommerce.entity.Orders;

public interface OrderService {

	public Orders addOrder(Orders order);

	public List<Orders> getAll();

	public String updateOrder(Orders order);

	public String deleteOrder(int id);

	public Orders getOrderById(int id);

	public List<Orders> saveAll(List<Orders> orders);

}
