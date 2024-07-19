package com.example.demo.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.OrderItem;
import com.example.demo.Entity.Product;
import com.example.demo.Exceptions.OrderNotFoundException;
import com.example.demo.Model.OrderDao;
import com.example.demo.Model.OrderItemDto;
import com.example.demo.Repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public Order saveOrder(OrderDao orderDao) 
	{	
		//getting customerId and orderItems from OrderDao class 
		int customerId=orderDao.getCustomerId();
		List<OrderItemDto> orderItemDto=orderDao.getOrderItems();
		
		
		List<OrderItem> orderItems=new ArrayList<>();
		Order order=new Order();
		
		orderItemDto.forEach(itemDto->{
			OrderItem orderItem=new OrderItem();
			
			//getting quantity and productId from OrderItemDto class to set in OrderItem class
			int qnty=itemDto.getQuantity();
			int productId=itemDto.getProductId();
			
			Product product=productService.findProductById(productId);
			
			orderItem.setQuantity(qnty);
			orderItem.setProduct(product);
			orderItem.setOrder(order);
			orderItem.setItemTotal(product.getProductPrice()*qnty);
			
			//adding orderItem in orderItems list
			orderItems.add(orderItem);
			
			
		});
			
		//getting customer object by calling customerService method in CustomerService class
		Customer customer=customerService.findCustomerById(customerId);
		
		//To calculate all Itemtotal in OrderItem class for setting in orderAmount in Order class
		double orderAmount=0.0;
		for(OrderItemDto itemDto:orderItemDto)
		{
			int qty=itemDto.getQuantity();
			int productId=itemDto.getProductId();
			Product product=productService.findProductById(productId);
			orderAmount+=product.getProductPrice()*qty;
		}
		
		order.setOrderDate(LocalDate.now());
		order.setOrderStatus("new");
		//setting customer object
		order.setCustomer(customer);
		
		//setting orderItems list
		order.setOrderItems(orderItems);
		
		//setting orderAmount calculated above
		order.setOrderAmount(orderAmount);
		
		orderRepository.save(order);
		return order;
		
	}

	@Override
	public Order findOrderById(int orderId) throws OrderNotFoundException
	{
		
		Optional<Order>  optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) 
		{
			throw new OrderNotFoundException("Order not existing with id: "+orderId);
		}
		
		Order order = optionalOrder.get();
		return order;
	}

	@Override
	public List<Order> findAllOrders() 
	{
		return orderRepository.findAll();
	}
	
	@Override
	public void deleteOrder(int orderId) throws OrderNotFoundException
	{
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty())
		{
			throw new OrderNotFoundException("Order not existing with id: "+orderId);
		}
		
		Order order = optionalOrder.get();
		orderRepository.delete(order);
	}
	
}
