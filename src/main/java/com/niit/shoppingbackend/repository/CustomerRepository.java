package com.niit.shoppingbackend.repository;

import java.util.List;

import com.niit.shoppingbackend.model.Customer;



public interface CustomerRepository {
	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	List<Customer> getAllCustomers();
	boolean deleteCustomer(int customerId);
	Customer getCustomerById(int customerId);
	Customer getCustomerByEmail(String customerEmail);

}
