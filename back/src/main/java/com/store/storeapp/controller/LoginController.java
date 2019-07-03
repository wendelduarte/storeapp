package com.store.storeapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.models.Customer;
import com.store.storeapp.models.Provider;
import com.store.storeapp.service.CustomerService;
import com.store.storeapp.service.ProviderService;

@RestController
public class LoginController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProviderService providerService;
	
	@CrossOrigin
	@GetMapping("/login/customer/{email}/{password}")
	public ResponseEntity<Customer> loginCustomer(@PathVariable String email, @PathVariable String password) {
		Customer customer = customerService.findByEmail(email);
		if(password.equals(customerService.getPasswordByEmail(email))) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}else {
			return new ResponseEntity<Customer>(customer, HttpStatus.UNAUTHORIZED);
		}

	}
	
	@CrossOrigin
	@GetMapping("/login/provider/{email}/{password}")
	public ResponseEntity<Provider> loginProvider(@PathVariable String email, @PathVariable String password) {
		Provider provider = providerService.findByEmail(email);
		if(password.equals(providerService.getPasswordByEmail(email))) {
			return new ResponseEntity<Provider>(provider, HttpStatus.OK);
		}else {
			return new ResponseEntity<Provider>(provider, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@CrossOrigin
	@GetMapping("/logout/customer")
	public String logoutCustomer(HttpSession session) {
		session.removeAttribute("customerInformations");
		return "/index";
	}
	
	@CrossOrigin
	@GetMapping("/logout/provider")
	public String logoutProvider(HttpSession session) {
		session.removeAttribute("providerInformations");
		return "/index";
	}
	
}
