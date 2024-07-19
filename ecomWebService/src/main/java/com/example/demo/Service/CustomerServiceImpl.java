 package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Exceptions.CustomerNotFoundException;
import com.example.demo.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer)
	{		
		customerRepository.save(customer);		
		return customer;
	}

	@Override
	public Customer findCustomerById(int customerId) throws CustomerNotFoundException
	{		
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) 
		{
			throw new CustomerNotFoundException("customer not existing with id: "+customerId);
		}		
		Customer customer = optionalCustomer.get();		
		return customer;
	}

	@Override
	public List<Customer> findAllCusotmers() 
	{		
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException
	{		
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if(optionalCustomer.isEmpty()) 
		{
			
		}		
		customerRepository.save(customer);		
		return customer;
	}


	@Override
	public void deleteCustomer(int customerId) throws CustomerNotFoundException
	{
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty())
		{
			throw new CustomerNotFoundException("customer not existing with id: "+customerId); 
			
		}
		
		Customer customer = optionalCustomer.get();
		customerRepository.delete(customer);
	}

}
