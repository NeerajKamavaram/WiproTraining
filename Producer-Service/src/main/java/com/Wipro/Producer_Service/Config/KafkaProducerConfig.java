package com.Wipro.Producer_Service.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.Wipro.Producer_Service.Model.Customer;

@Configuration
public class KafkaProducerConfig
{
	@Bean
	ProducerFactory<String,String> producerFactory()
	{
		Map<String,Object> configProps=new HashMap<>();
		
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(configProps);
	
	}
	
	@Bean
	KafkaTemplate<String,String> kafkaTemplate()
	{
		return new KafkaTemplate<>(producerFactory());
	}
	
	@Bean
	ProducerFactory<String,Customer> customerProducerFactory()
	{
		Map<String,Object> configProps=new HashMap<>();
		
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(configProps);
	
	}
	
	@Bean
	KafkaTemplate<String,Customer> CustomerKafkaTemplate()
	{
		return new KafkaTemplate<>(customerProducerFactory());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
