package com.Wipro.Producer_Service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageProducer
{
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public void sendMessage(String msg)
	{
		kafkaTemplate.send("sample-topic",msg);
	}
	
	
	
	
}