package com.example.demo.Entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name="product_tbl")
public class Product 
{
	@Id
	@Column("product_id")
	private int productId;
	
	@Column("product_name")
	private String productName;
	
	@Column("product_price")
	private double productPrice;
	
	private LocalDate mfd;
	
	private String category;
}
