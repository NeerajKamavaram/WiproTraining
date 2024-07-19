package com.Wipro.CustomerService.Service;

import java.util.List;

import com.Wipro.CustomerService.Model.Customer;

public interface CustomerService 
{
	//CRUD operations
	
	Customer saveCustomer(Customer customer);
	
	Customer findCustomerById(int customerId);
	
	List<Customer> findAllCusotmers();
	
	Customer updateCustomer(Customer customer);
	
	void deleteCustomer(int customerId);
	
	List<Customer> findCustomerByCity(String address);
	
	List<Customer> findCustomersByAboveAge(int age);
}
