package com.store.storeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.models.Customer;
import com.store.storeapp.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@PostMapping("/customer/post")
	public void setCustomer(@RequestBody Customer customer) {
		customerService.setCustomer(customer);
	}
	
	@PutMapping("/customer/att/{id}")
	public void updateCustomer(@PathVariable Customer id, @RequestBody Customer update) {
		customerService.updateCustomer(update);
	}
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable Customer id) {
		customerService.deleteCustomer(id);
	}
}
