package com.store.storeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storeapp.models.Customer;
import com.store.storeapp.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	public void setCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void updateCustomer(Customer id) {
		customerRepository.save(id);
	}
	
	public void deleteCustomer(Customer id) {
		customerRepository.delete(id);
	}
}
