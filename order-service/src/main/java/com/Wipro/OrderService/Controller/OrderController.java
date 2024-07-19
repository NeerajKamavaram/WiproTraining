package com.Wipro.OrderService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Wipro.OrderService.Entity.OrderEntity;
import com.Wipro.OrderService.Model.Order;
import com.Wipro.OrderService.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/save")
	public ResponseEntity<OrderEntity> placeOrder(@RequestBody OrderEntity orderEntity) 
	{
		OrderEntity neworder = orderService.saveOrder(orderEntity);
		return new ResponseEntity<>(neworder,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Order> fetchOrderDetails(@PathVariable("id") int orderId) 
	{
		Order order = orderService.findOrderById(orderId);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Order> fetchAllOrders()
	{		
		return orderService.findAllOrders();
	}
}