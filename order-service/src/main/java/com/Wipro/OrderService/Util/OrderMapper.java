package com.Wipro.OrderService.Util;

import java.util.ArrayList;
import java.util.List;

import com.Wipro.OrderService.Entity.OrderEntity;
import com.Wipro.OrderService.Entity.OrderItemEntity;
import com.Wipro.OrderService.Model.Order;
import com.Wipro.OrderService.Model.OrderItem;

public class OrderMapper 
{
	public static OrderEntity MapToEntity(Order order)
	{
		OrderEntity orderEntity=new OrderEntity();
		
		orderEntity.setOrderId(order.getOrderId());
		orderEntity.setOrderAmount(order.getOrderAmount());
		orderEntity.setOrderDate(order.getOrderDate());
		orderEntity.setOrderStatus(order.getOrderStatus());
		//orderEntity.setCustomer_id(order.getCustomerId());
		
		List<OrderItem> orderItemList=order.getOrderItems();
		List<OrderItemEntity> orderItemEntityList=OrderItemMapper.mapToEntityList(orderItemList);
		orderEntity.setOrderItems(orderItemEntityList);
		
		return orderEntity;
	}
	
	public static Order MapToModel(OrderEntity orderEntity)
	{
		Order order=new Order();
		
		order.setOrderId(orderEntity.getOrderId());
		order.setOrderAmount(orderEntity.getOrderAmount());
		order.setOrderDate(orderEntity.getOrderDate());
		order.setOrderStatus(orderEntity.getOrderStatus());
		//order.setCustomerId(orderEntity.getCustomer_id());
		
		List<OrderItemEntity> orderItemEntityList=orderEntity.getOrderItems();
		List<OrderItem> orderItem=OrderItemMapper.mapToModelList(orderItemEntityList);
		order.setOrderItems(orderItem);
		
		return order;
	}
	
	public static List<Order> MapToModelList(List<OrderEntity> orderEntity)
	{
		List<Order> orderList=new ArrayList<>();
		
		for(OrderEntity itemEntity: orderEntity)
		{
			Order order=OrderMapper.MapToModel(itemEntity);
			orderList.add(order);
		}
		return orderList;
	}
	
	public static List<OrderEntity> MapToEntityList(List<Order> order)
	{
		List<OrderEntity> orderEntityList=new ArrayList<>();
		
		for(Order i:order)
		{
			OrderEntity orderEntity=OrderMapper.MapToEntity(i);
			orderEntityList.add(orderEntity);
		}
		return orderEntityList;
	}
	

}
