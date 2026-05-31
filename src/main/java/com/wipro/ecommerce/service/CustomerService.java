package com.wipro.ecommerce.service;

import java.util.List;

import com.wipro.ecommerce.entity.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);

	public List<Customer> getAll();

	public String updateCustomer(Customer customer);

	public String deleteCustomerById(int id);

	public Object getCustomerById(int id);

	public List<Customer> saveAll(List<Customer> customers);

}
