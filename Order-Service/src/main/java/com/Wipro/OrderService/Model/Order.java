package com.Wipro.OrderService.Model;

import java.time.LocalDate;
import java.util.List;

import com.Wipro.OrderService.Entity.OrderItemEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order 
{
	
	private int orderId;
	
	private double orderAmount;
	
	private LocalDate orderDate;
	
	private String orderStatus;
	
	private Customer customer;
	
	private List<OrderItem> orderItems;

}
