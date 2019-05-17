package com.store.storeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.Utils;
import com.store.storeapp.models.CardCustomer;
import com.store.storeapp.models.Customer;
import com.store.storeapp.service.CardCustomerService;

@RestController
public class CardCustomerController {

	@Autowired
	private CardCustomerService cardCustomerService;
	
	@Autowired
	private Utils utilM;
	
	@GetMapping("/card/{customerId}")
	public ResponseEntity<List<?>> getAllCardOfCustomer(@PathVariable Customer customer){
		List<CardCustomer> allCardOfCustomer = cardCustomerService.getAllCardByCustomer(customer);
		return utilM.getAll(allCardOfCustomer);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/card/post")
	public CardCustomer setCardCustomer(CardCustomer card) {
		return cardCustomerService.setCardCustomer(card);
	}
	
	@DeleteMapping("/card/{customer}/{cardCustomer}")
	public ResponseEntity<?> deleteProduct(@PathVariable Customer customer, @PathVariable CardCustomer cardCustomer){
		boolean card = cardCustomerService.deleteCardCustomer(customer, cardCustomer);
		return utilM.delete(card);
	}
}
