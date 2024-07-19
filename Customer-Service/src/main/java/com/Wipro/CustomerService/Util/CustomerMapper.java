package com.Wipro.CustomerService.Util;

import java.util.ArrayList;
import java.util.List;

import com.Wipro.CustomerService.Entity.CustomerEntity;
import com.Wipro.CustomerService.Model.Customer;

public class CustomerMapper 
{
	public static CustomerEntity mapToEntity(Customer customer) 
	{
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setCustomerId(customer.getCustomerId());
		customerEntity.setCustomerName(customer.getCustomerName());
		customerEntity.setAge(customer.getAge());
		customerEntity.setEmail(customer.getEmail());
		customerEntity.setMobile(customer.getMobile());
		return customerEntity;
	}
	
	public static Customer mapToModel(CustomerEntity customerEntity) 
	{		
		Customer customer = new Customer();
		customer.setCustomerId(customerEntity.getCustomerId());
		customer.setCustomerName(customerEntity.getCustomerName());
		customer.setAge(customerEntity.getAge());
		customer.setEmail(customerEntity.getEmail());
		customer.setMobile(customerEntity.getMobile());
		return customer;
	}
	
	public static List<Customer> mapToModelList(List<CustomerEntity> customerEntityList) 
	{		
		List<Customer> customerList = new ArrayList<>();
		for(CustomerEntity customerEntity :customerEntityList) 
		{
			Customer customer = mapToModel(customerEntity);
			customerList.add(customer);
		}		 
		return customerList;
	}

}
