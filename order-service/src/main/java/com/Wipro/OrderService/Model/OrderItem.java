package com.Wipro.OrderService.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItem 
{
	private int orderItemId;
	
	private int quantity;
	
	private Product product;
	
	private double itemTotal;
	


}
