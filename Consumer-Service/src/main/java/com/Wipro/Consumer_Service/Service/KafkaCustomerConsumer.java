package com.Wipro.Consumer_Service.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.Wipro.Consumer_Service.Model.Customer;

@Service
public class KafkaCustomerConsumer 
{

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaCustomerConsumer.class);	

    @KafkaListener(topics = "sample-topic", groupId="neeraj",containerFactory = "customerKafkaListenerContainerFactory")
    public void consume(Customer customer)
    {
    	System.out.println("listening");
    	
    	LOGGER.info(customer.getCustomerName()+" "+customer.getCustomerEmail());
//    	System.out.println(customer.getCustomerName()+" "+customer.getCustomerEmail());
    }    
}
