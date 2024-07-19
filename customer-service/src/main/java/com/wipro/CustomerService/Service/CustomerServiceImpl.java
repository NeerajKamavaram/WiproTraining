package com.Wipro.CustomerService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Wipro.CustomerService.Entity.CustomerEntity;
import com.Wipro.CustomerService.Exceptions.CustomerNotFoundException;
import com.Wipro.CustomerService.Model.Customer;
import com.Wipro.CustomerService.Repository.CustomerRepository;
import com.Wipro.CustomerService.Util.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;

	
	@Override
	public Customer saveCustomer(Customer customer)
	{
		
		CustomerEntity customerEntity = CustomerMapper.mapToEntity(customer);
		customerRepository.save(customerEntity);			
		Customer customer2 = CustomerMapper.mapToModel(customerEntity);
		return customer2;
	}

	@Override
	public Customer findCustomerById(int customerId) throws CustomerNotFoundException
	{		
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) 
		{
			throw new CustomerNotFoundException("customer not existing with id: "+customerId);
		}		
		CustomerEntity customerEntity = optionalCustomer.get();	
		
		return CustomerMapper.mapToModel(customerEntity);
	}

	@Override
	public List<Customer> findAllCusotmers()
	{		
		List<CustomerEntity> customers = customerRepository.findAll();
		return CustomerMapper.mapToModelList(customers);
	}

	@Override
	public Customer updateCustomer(Customer customer) 
	{		
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if(optionalCustomer.isEmpty())
		{
			// throw some exception 
		}		
		
		CustomerEntity customerEntity = CustomerMapper.mapToEntity(customer);		
		customerRepository.save(customerEntity);			
		Customer customer2 = CustomerMapper.mapToModel(customerEntity);
		
		return customer2;
	}

	@Override
	public void deleteCustomer(int customerId) throws CustomerNotFoundException
	{
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) 
		{
			throw new CustomerNotFoundException("customer not existing with id: "+customerId);
		}
		
		CustomerEntity customerEntity = optionalCustomer.get();
		customerRepository.delete(customerEntity);
	}

	@Override
	public List<Customer> findCustomerByCity(String address) 
	{	
		List<CustomerEntity> customers = customerRepository.findByAddress(address);
		return CustomerMapper.mapToModelList(customers);
	}

	@Override
	public List<Customer> findCustomersByAboveAge(int age) 
	{	
		List<CustomerEntity> customers = customerRepository.findCustomersAboveAge(age);
		return CustomerMapper.mapToModelList(customers);
	}

}
