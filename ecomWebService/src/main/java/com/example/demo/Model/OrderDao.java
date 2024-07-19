package com.example.demo.Model;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDao 
{
	private int customerId;
	private List<OrderItemDto> orderItems;

}
