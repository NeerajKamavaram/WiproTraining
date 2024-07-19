package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Customer;
import com.example.demo.Exceptions.CustomerNotFoundException;

public interface CustomerService 
{
	//CRUD operations
	
	//adding data into db
	Customer saveCustomer(Customer customer);
	
	//fetching one record from db
	Customer findCustomerById(int customerId) throws CustomerNotFoundException;
	
	//fetching all records from db
	List<Customer> findAllCusotmers();
	
	//modifying one record in db
	Customer updateCustomer(Customer customer);
	
	//deleting one record in db
	void deleteCustomer(int customerId);
}
