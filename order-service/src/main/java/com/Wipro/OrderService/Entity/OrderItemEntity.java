package com.Wipro.OrderService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class OrderItemEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderitem_id")
	private int orderItemId;
	
	private int quantity;
	
	@Column(name="product_id")
	private int product_id;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonIgnore
	private OrderEntity orderEntity;
	
	@Column(name="item_total")
	private double itemTotal;
	
	
	
	

}
