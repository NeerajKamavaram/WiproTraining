package com.Wipro.KafkaFrst.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.Wipro.KafkaFrst.Model.Customer;

@Service
public class CustomerProducer 
{
	@Autowired
	private KafkaTemplate<String,Customer> kafkaTemplate;
	
	public void sendCustomer(Customer customer)
	{
		kafkaTemplate.send("sample-topic", customer);
	}
	
}
