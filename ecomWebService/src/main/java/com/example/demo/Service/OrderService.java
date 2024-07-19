package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Order;
import com.example.demo.Model.OrderDao;

public interface OrderService 
{
	Order saveOrder(OrderDao orderDao);
	
	Order findOrderById(int orderId);
	
	List<Order> findAllOrders();
	
	void deleteOrder(int orderId);

}
