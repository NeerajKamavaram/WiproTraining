package com.Wipro.OrderService.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Wipro.OrderService.Entity.OrderEntity;
import com.Wipro.OrderService.Entity.OrderItemEntity;
import com.Wipro.OrderService.Exceptions.ResourceNotFoundException;
import com.Wipro.OrderService.Model.Customer;
import com.Wipro.OrderService.Model.Order;
import com.Wipro.OrderService.Model.OrderItem;
import com.Wipro.OrderService.Model.Product;
import com.Wipro.OrderService.Repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private ProductApiClient productApiClient;
	
	@Autowired
	private CustomerApiClient customerApiClient;
		

	@Override
	public OrderEntity saveOrder(OrderEntity orderEntity) 
	{
		List<OrderItemEntity> orderItems = orderEntity.getOrderItems();
		double orderTotal = 0;
		for (OrderItemEntity item : orderItems) 
		{
			//call Product-service getProductById() method to get the product details
			
			//using RestTemplate			
//			ResponseEntity<Product> responseEntity = restTemplate
//					.getForEntity("http://localhost:8081/product/" + item.getProductId(), Product.class);
//			Product product = responseEntity.getBody();
			
			// using Feign client			
			Product product = productApiClient.getProductDetails(item.getProduct_id());
			
			double itemTotal = item.getQuantity()*product.getProductPrice();
			item.setItemTotal(itemTotal);
			
			orderTotal+=itemTotal;
			
			item.setOrderEntity(orderEntity);
		}

		//set total order amount
		orderEntity.setOrderAmount(orderTotal);
		orderEntity.setOrderStatus("New");
		orderEntity.setOrderDate(LocalDate.now());	
		
		orderRepository.save(orderEntity);	

		return orderEntity;
	}

	@Override
	public Order findOrderById(int orderId) 
	{

		Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderId);
		if (optionalOrderEntity.isEmpty()) 
		{
			throw new ResourceNotFoundException("Order not found with id: "+orderId);
		}
		OrderEntity orderEntity = optionalOrderEntity.get();
		
		//using RestTemplate
//		ResponseEntity<Customer> responseEntity = restTemplate
//				.getForEntity("http://localhost:8082/customer/get/" + orderEntity.getCustomerId(), Customer.class);
//		Customer customer = responseEntity.getBody();
		
		//using Feign client
		Customer customer = customerApiClient.getCustomerDetails(orderEntity.getCustomer_id());
		
		
		Order order = new Order();
		order.setOrderId(orderEntity.getOrderId());
		order.setOrderAmount(orderEntity.getOrderAmount());
		order.setOrderDate(orderEntity.getOrderDate());
		order.setOrderStatus(orderEntity.getOrderStatus());
		order.setCustomer(customer);
		
		List<OrderItemEntity> orderItemEntityList = orderEntity.getOrderItems();
		
		List<OrderItem> orderItems = new ArrayList<>();
		
		for(OrderItemEntity orderItemEntity : orderItemEntityList) 
		{
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderItemId(orderItemEntity.getOrderItemId());
			orderItem.setQuantity(orderItemEntity.getQuantity());
			orderItem.setItemTotal(orderItemEntity.getItemTotal());
			
//			ResponseEntity<Product> productResponseEntity = restTemplate
//					.getForEntity("http://localhost:8081/product/" +orderItemEntity.getProductId(), Product.class);
//			Product product = productResponseEntity.getBody();
			
			//Feign client
			Product product = productApiClient.getProductDetails(orderItemEntity.getProduct_id());
			
			orderItem.setProduct(product);
			
			orderItems.add(orderItem);			
		}
		
		order.setOrderItems(orderItems);		
				
		return order;
	}

	@Override
	public List<Order> findAllOrders() 
	{
		List<OrderEntity> orderEntityList = orderRepository.findAll();	
		
		List<Order> allOrders=new ArrayList<>();
		
		for(OrderEntity orderEntity:orderEntityList)
		{
			//using Feign client
			Customer customer = customerApiClient.getCustomerDetails(orderEntity.getCustomer_id());
			Order order = new Order();
			order.setOrderId(orderEntity.getOrderId());
			order.setOrderAmount(orderEntity.getOrderAmount());
			order.setOrderDate(orderEntity.getOrderDate());
			order.setOrderStatus(orderEntity.getOrderStatus());
			order.setCustomer(customer);
			
			List<OrderItemEntity> orderItemEntityList = orderEntity.getOrderItems();
			
			List<OrderItem> orderItems = new ArrayList<>();
			
			for(OrderItemEntity orderItemEntity : orderItemEntityList) 
			{
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderItemId(orderItemEntity.getOrderItemId());
				orderItem.setQuantity(orderItemEntity.getQuantity());
				orderItem.setItemTotal(orderItemEntity.getItemTotal());
				
				//Feign client
				Product product = productApiClient.getProductDetails(orderItemEntity.getProduct_id());
				
				orderItem.setProduct(product);
				
				orderItems.add(orderItem);	
			}
			
			order.setOrderItems(orderItems);
			
			allOrders.add(order);
			
		}
		return allOrders;
	}

	@Override
	public void deleteOrder(int orderId) 
	{
		Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderId);
		if (optionalOrderEntity.isEmpty()) 
		{
			throw new ResourceNotFoundException("Order not found with id: " + orderId);
		}
		OrderEntity orderEntity = optionalOrderEntity.get();
		orderRepository.delete(orderEntity);

	}



}
