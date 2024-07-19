package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="orderitem_tbl")
public class OrderItem 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderitem_id")
	private int orderItemId;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private int quantity;
	
	@Column(name="item_total")
	private double itemTotal;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	

}
