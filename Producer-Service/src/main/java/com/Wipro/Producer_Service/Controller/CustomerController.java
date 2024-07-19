package com.Wipro.Producer_Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Wipro.Producer_Service.Model.Customer;
import com.Wipro.Producer_Service.Service.KafkaCustomerProducer;

@RestController
@RequestMapping("/api")
public class CustomerController 
{
	@Autowired
	private KafkaCustomerProducer kafkaCustomerProducer;
	
	@PostMapping("/customer")
	public ResponseEntity<String> produceCustomer(@RequestBody Customer customer)
	{
		kafkaCustomerProducer.sendCustomer(customer);
		return new ResponseEntity<>("customer obj sent",HttpStatus.CREATED);
	}
}
