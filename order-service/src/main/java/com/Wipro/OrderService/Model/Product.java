package com.Wipro.OrderService.Model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product 
{
	private int productId;
	private String productName;	
	private double productPrice;	
	private LocalDate mfd;	
	private String category;
}
