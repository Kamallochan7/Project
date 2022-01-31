package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecom.dto.OrderResponse;
import com.ecom.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT new com.ecom.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInformation();



}
