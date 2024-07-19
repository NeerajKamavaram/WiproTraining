package com.Wipro.Consumer_Service.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.Wipro.Consumer_Service.Model.Customer;

@Configuration
public class KafkaConsumerConfig 
{
//	@Bean
//	ConsumerFactory<String, String> consumerFactory() 
//	{
//		Map<String, Object> configProps = new HashMap<>();
//		
//		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
//		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		
//		return new DefaultKafkaConsumerFactory<>(configProps);
//	}
//
//	@Bean
//	ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() 
//	{
//		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//		factory.setConsumerFactory(consumerFactory());
//		return factory;
//	}

	@Bean
	ConsumerFactory<String, Customer> customerConsumerFactory() 
	{
		JsonDeserializer<Customer> jsonDeserializer=new JsonDeserializer<>(Customer.class,false);
		jsonDeserializer.addTrustedPackages("*");
		
		Map<String, Object> configProps = new HashMap<>();
		
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "neeraj");		
		return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(),jsonDeserializer);
	}

	@Bean
	ConcurrentKafkaListenerContainerFactory<String, Customer> customerKafkaListenerContainerFactory()
	{
		ConcurrentKafkaListenerContainerFactory<String, Customer> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(customerConsumerFactory());
		return factory;
	}

	
}
