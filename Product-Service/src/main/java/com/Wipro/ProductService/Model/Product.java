package com.Wipro.ProductService.Model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product 
{
	private int productId;
	
	private String productName;
	
	private double productPrice;
	
	private LocalDate mfd;
	
	private String category;

}
