package com.wipro.ecommerce.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.ecommerce.entity.Orders;
import com.wipro.ecommerce.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repo;

	public Orders addOrder(Orders order) {
		return repo.save(order);
	}

	public List<Orders> getAll() {
		return repo.findAll();
	}

	public String updateOrder(Orders order) {
		if (order.getId() == 0) {
			return "ID is required for update";
		}
		Optional<Orders> opt = repo.findById(order.getId());

		if (opt.isPresent()) {
			repo.save(order);
			return "Order updated successfully";
		} else {
			return "No record found with id: " + order.getId();
		}
	}

	public String deleteOrder(int id) {
		Optional<Orders> opt = repo.findById(id);
		if (!opt.isEmpty()) {
			repo.deleteById(id);
			return "Order successfully deleted";
		}
		return "No record found with id: " + id;
	}

	public Orders getOrderById(int id) {
		Optional<Orders> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public List<Orders> saveAll(List<Orders> orders) {
		return repo.saveAll(orders);
	}
}