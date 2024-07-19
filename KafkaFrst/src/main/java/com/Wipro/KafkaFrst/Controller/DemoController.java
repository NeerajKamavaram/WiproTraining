package com.Wipro.KafkaFrst.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Wipro.KafkaFrst.Model.Customer;
import com.Wipro.KafkaFrst.Service.CustomerProducer;
import com.Wipro.KafkaFrst.Service.KafkaProducer;

@RestController
@RequestMapping("/api")
public class DemoController 
{
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Autowired
	private CustomerProducer customerProducer;
	
	@GetMapping("/send/{msg}")
	public ResponseEntity<String> produceMessage(@PathVariable("msg") String msg) 
	{
		kafkaProducer.sendMessage(msg);
		return new ResponseEntity<>("message sent to server",HttpStatus.CREATED);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> produceCustomer(@RequestBody Customer customer)
	{
		customerProducer.sendCustomer(customer);
		
		return new ResponseEntity<>(customer,HttpStatus.CREATED);
	}
}
