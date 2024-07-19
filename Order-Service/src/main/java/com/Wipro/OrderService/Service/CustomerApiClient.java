package com.Wipro.OrderService.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Wipro.OrderService.Model.Customer;

@FeignClient(value="CUSTOMER-SERVICE")
public interface CustomerApiClient
{
	@GetMapping("/customer/get/{id}")
	public Customer getCustomerDetails(@PathVariable("id") int customerId);

}
