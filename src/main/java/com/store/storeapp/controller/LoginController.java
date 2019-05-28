package com.store.storeapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/login/customer")
	public boolean loginCustomer(@RequestParam("email") String customerEmail, @RequestParam("password") String customerPassword, HttpSession session) {
		Customer customer = customerService.findByEmail(customerEmail);
		if(customerPassword == customerService.getPasswordByEmail(customerEmail)) {
			session.setAttribute("customerInformations", customer);
			return true;
		}else {
			return false;
		}
	}
	@PostMapping("/login/provider")
	public boolean loginProvider(@RequestParam("email") String providerEmail, @RequestParam("password") String providerPassword, HttpSession session) {
		Provider provider = providerService.findByEmail(providerEmail);
		if(providerPassword == providerService.getPasswordByEmail(providerEmail)) {
			session.setAttribute("providerInformations", provider);
			return true;
		}else {
			return false;
		}
	}
	
	@GetMapping("/logout/customer")
	public String logoutCustomer(HttpSession session) {
		session.removeAttribute("customerInformations");
		return "/index";
	}
	
	@GetMapping("/logout/provider")
	public String logoutProvider(HttpSession session) {
		session.removeAttribute("providerInformations");
		return "/index";
	}
	
}
