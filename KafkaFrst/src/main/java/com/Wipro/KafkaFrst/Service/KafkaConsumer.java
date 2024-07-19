package com.Wipro.KafkaFrst.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.Wipro.KafkaFrst.Model.Customer;

@Service
public class KafkaConsumer
{
	private static final Logger logger=LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics="sample-topic",groupId="neeraj")
	public void consumeMessage(String message)
	{
		logger.info(message);
	}
	
}
