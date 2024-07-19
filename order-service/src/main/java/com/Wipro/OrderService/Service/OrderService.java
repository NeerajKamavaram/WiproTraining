package com.Wipro.OrderService.Service;

import java.util.List;
import com.Wipro.OrderService.Entity.OrderEntity;
import com.Wipro.OrderService.Model.Order;

public interface OrderService 
{
	OrderEntity saveOrder(OrderEntity orderEntity);
	
	Order findOrderById(int orderId);
	
	List<Order> findAllOrders();
	
//	OrderEntity updateOrder(OrderEntity orderEntity);
	
	void deleteOrder(int orderId);

}
