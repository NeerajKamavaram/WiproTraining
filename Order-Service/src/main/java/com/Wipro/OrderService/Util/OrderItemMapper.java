package com.Wipro.OrderService.Util;

import java.util.ArrayList;
import java.util.List;

import com.Wipro.OrderService.Entity.OrderItemEntity;
import com.Wipro.OrderService.Model.OrderItem;

public class OrderItemMapper 
{
	public static OrderItem mapToModel(OrderItemEntity orderItemEntity)
	{
		OrderItem orderItem=new OrderItem();
		
		orderItem.setItemTotal(orderItemEntity.getItemTotal());
		orderItem.setOrderItemId(orderItemEntity.getOrderItemId());
		//orderItem.setProductId(orderItemEntity.getProduct_id());
		orderItem.setQuantity(orderItemEntity.getQuantity());
		
		return orderItem;
	}
	
	public static OrderItemEntity mapToEntity(OrderItem orderItem)
	{
		OrderItemEntity orderItemEntity=new OrderItemEntity();
		
		orderItemEntity.setItemTotal(orderItem.getItemTotal());
		orderItemEntity.setOrderItemId(orderItem.getOrderItemId());
		//orderItemEntity.setProduct_id(orderItem.getProductId());
		orderItemEntity.setQuantity(orderItem.getQuantity());
		
		return orderItemEntity;
	}
	
	public static List<OrderItem> mapToModelList(List<OrderItemEntity> orderItemEntity)
	{
		List<OrderItem> orderItemList=new ArrayList<>();
		
		for(OrderItemEntity i:orderItemEntity)
		{
			OrderItem orderItem=OrderItemMapper.mapToModel(i);
			orderItemList.add(orderItem);
		}
		return orderItemList;
	}
	
	public static List<OrderItemEntity> mapToEntityList(List<OrderItem> orderItem)
	{
		List<OrderItemEntity> orderItemEntityList=new ArrayList<>();
		
		for(OrderItem i:orderItem)
		{
			OrderItemEntity orderItemEntity=OrderItemMapper.mapToEntity(i);
			orderItemEntityList.add(orderItemEntity);
		}
		return orderItemEntityList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
