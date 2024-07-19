package com.Wipro.OrderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Wipro.OrderService.Entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>
{

}
