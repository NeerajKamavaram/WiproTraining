package com.Wipro.OrderService.Entity;

import java.time.LocalDate;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="order_tbl")
public class OrderEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_amount")
	private double orderAmount;
	
	@Column(name="order_date")
	private LocalDate orderDate;
	
	@Column(name="order_status")
	private String orderStatus;
	
	@Column(name="customer_id")
	private int customer_id;
	
	
	@OneToMany(mappedBy="orderEntity",cascade=CascadeType.ALL)
	private List<OrderItemEntity> orderItems;

}
