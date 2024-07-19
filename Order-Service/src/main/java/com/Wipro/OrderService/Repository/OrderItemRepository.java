package com.Wipro.OrderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Wipro.OrderService.Entity.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Integer>
{

}
