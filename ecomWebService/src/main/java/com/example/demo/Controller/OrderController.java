package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Order;
import com.example.demo.Model.OrderDao;
import com.example.demo.Service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:3000/")
public class OrderController 
{
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/save")
	public ResponseEntity<Order> placeOrder(@RequestBody OrderDao orderDao) 
	{
		Order order = orderService.saveOrder(orderDao);
		return new ResponseEntity<>(order,HttpStatus.CREATED);
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
