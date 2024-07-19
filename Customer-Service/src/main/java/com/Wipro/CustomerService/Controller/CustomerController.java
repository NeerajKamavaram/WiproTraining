package com.Wipro.CustomerService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Wipro.CustomerService.Model.Customer;
import com.Wipro.CustomerService.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/all")
	public List<Customer> fetchAllCustomers() 
	{		
		List<Customer> customers = customerService.findAllCusotmers();
		return customers;
	}	
	
	@PostMapping("/save")
	public ResponseEntity<Customer>  addCustomer(@RequestBody Customer customer) 
	{
		customerService.saveCustomer(customer);		
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(customer,HttpStatus.CREATED);		
		return responseEntity;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> fetchCustomerDetails( @PathVariable("id") int customerId) 
	{
		
		Customer customer = customerService.findCustomerById(customerId);
		
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(customer,HttpStatus.OK);	
		return responseEntity;
	}	
	
	@PutMapping("/update")
	public ResponseEntity<Customer>  modifyCustomer(@RequestBody Customer customer)
	{
		
		customerService.updateCustomer(customer);
		
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(customer,HttpStatus.OK);		
		return responseEntity;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> removeCustome( @PathVariable("id") int customerId) 
	{
		
		customerService.deleteCustomer(customerId);
		
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);	
		return responseEntity;
	}	
	
	
	@GetMapping("/filterbycity")
	public List<Customer> fetchCustomerDetailsByCity( @RequestParam("city") String city)
	{
		
		List<Customer> customers = customerService.findCustomerByCity(city);		
		
		return customers;
	}
	
	@GetMapping("/filterbyage")
	public List<Customer> fetchCustomerAboveAge( @RequestParam("age") int age) 
	{
		
		List<Customer> customers = customerService.findCustomersByAboveAge(age);		
		
		return customers;
	}

}
