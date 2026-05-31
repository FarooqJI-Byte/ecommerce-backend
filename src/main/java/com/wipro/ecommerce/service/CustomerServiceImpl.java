package com.wipro.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.entity.Customer;
import com.wipro.ecommerce.exceptions.InvalidInputException;
import com.wipro.ecommerce.exceptions.ResourceNotFoundException;
import com.wipro.ecommerce.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repo;

	public Customer addCustomer(Customer customer) {
		return repo.save(customer);
	}

	public List<Customer> getAll() {
		return repo.findAll();
	}

	public String updateCustomer(Customer customer) {
		if (customer.getId() == 0) {
			throw new InvalidInputException("ID is required for update");
		}
		Optional<Customer> opt = repo.findById(customer.getId());

		if (opt.isPresent()) {
			repo.save(customer);
			return "Customer updated successfully";
		} else {
			throw new ResourceNotFoundException("No record found with id: " + customer.getId());
		}

	}

	public String deleteCustomerById(int id) {
		Optional<Customer> opt = repo.findById(id);
		if (!opt.isEmpty()) {
			return "Customer successfully deleted";
		}
		throw new ResourceNotFoundException("No record found with id: " + id);
	}

	public Object getCustomerById(int id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
	}

	public List<Customer> saveAll(List<Customer> customers) {
		return repo.saveAll(customers);
	}

}
