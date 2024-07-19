package com.Wipro.CustomerService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Wipro.CustomerService.Entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>
{
	List<CustomerEntity> findByAddress(String address) ;
	
	Optional<CustomerEntity> findByEmail(String email);
	
	@Query("select c from CustomerEntity c where c.age > :cage")
	List<CustomerEntity>  findCustomersAboveAge(@Param("cage") int age);
}
