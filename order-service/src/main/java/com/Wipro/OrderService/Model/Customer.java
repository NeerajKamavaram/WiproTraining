package com.Wipro.OrderService.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer 
{
	private int customerId;	
	private String customerName;	
	private int age;	
	private String email;		
	private String city;	
	private String mobile;
}
