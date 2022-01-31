package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.OrderRequest;
import com.ecom.dto.OrderResponse;
import com.ecom.entity.Customer;
import com.ecom.pojo.UpdateAddressRequest;
import com.ecom.repository.CustomerRepository;
import com.ecom.repository.ProductRepository;




@RestController
public class OrderController {
@Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
    return customerRepository.save(request.getCustomer());
       }
    

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }
    

    @PutMapping("/update-address")
	public Customer updateCustomerAddress(@RequestBody UpdateAddressRequest request) {
	
		Customer currentCustomer = customerRepository.getById(request.getId());
		currentCustomer.setAddress(request.getAddress()); 
		Customer updatedCustomer = customerRepository.save(currentCustomer); 
		
		return updatedCustomer;
	}
    
	@DeleteMapping("/delete")
	public String deleteCustomer(@RequestBody UpdateAddressRequest request) {
		
		customerRepository.deleteById(request.getId());
		return "Customer Deleted Successfully";
	}
	
	
}
