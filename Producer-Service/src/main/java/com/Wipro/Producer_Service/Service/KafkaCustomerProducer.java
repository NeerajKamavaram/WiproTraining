package com.Wipro.Producer_Service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.Wipro.Producer_Service.Model.Customer;

@Service
public class KafkaCustomerProducer 
{
	@Autowired
	private KafkaTemplate<String,Customer> kafkaTemplate;
	
	public void sendCustomer(Customer customer)
	{
		kafkaTemplate.send("sample-topic",customer);
	}

}
