package com.Wipro.Student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.Wipro.Student.Model.Student;


@Service
public class KafkaStudentProducer
{
	@Autowired
	private KafkaTemplate<String,Student> kafkaTemplate;
	
	public void sendCustomer(Student student)
	{
		kafkaTemplate.send("sample-topic",student);
	}

}
