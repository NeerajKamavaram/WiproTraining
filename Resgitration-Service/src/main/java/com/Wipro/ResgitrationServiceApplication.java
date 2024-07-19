package com.Wipro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ResgitrationServiceApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(ResgitrationServiceApplication.class, args);
	}

}
