package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000/")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		customerService.saveCustomer(customer);
		ResponseEntity<Customer> re=new ResponseEntity<Customer>(customer,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/all")
	public List<Customer> fetchAllCustomers() 
	{		
		List<Customer> customers = customerService.findAllCusotmers();
		return customers;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> fetchCustomerDetails(@PathVariable("id") int customerId)
	{
		
		Customer customer = customerService.findCustomerById(customerId);
		ResponseEntity<Customer> re = new ResponseEntity<>(customer,HttpStatus.OK);	
		return re;
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
		ResponseEntity<Void> re = new ResponseEntity<>(HttpStatus.OK);	
		return re;
	}

}
