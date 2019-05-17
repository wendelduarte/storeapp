package com.store.storeapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	
	public Optional<Customer> getOneCustomer(Long id){
		return customerRepository.findById(id);
	}
	
	public void setCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public Optional<Customer> updateCustomer(Customer updateCustomer, Long id) {
		Optional<Customer> customer = getOneCustomer(id);
		if(customer.isPresent()) {
			return customer = Optional.of(customerRepository.save(updateCustomer));
		}
		return null;
	}
	
	@Transactional
	public boolean deleteCustomer(Long customerId) {
		Optional<Customer> customer = getOneCustomer(customerId);
		if(customer.isPresent()) {
			customerRepository.deleteById(customerId);
			return true;
		}
		return false;			
	}
}
