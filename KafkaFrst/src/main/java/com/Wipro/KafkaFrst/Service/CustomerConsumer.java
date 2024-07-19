package com.Wipro.KafkaFrst.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.Wipro.KafkaFrst.Model.Customer;

public class CustomerConsumer 
{
	private static final Logger logger=LoggerFactory.getLogger(CustomerConsumer.class);
	
	@KafkaListener(topics="sample-topic",groupId="neeraj")
	public void consumeCustomer(Customer customer)
	{
		logger.info(customer.toString());
	}

}
