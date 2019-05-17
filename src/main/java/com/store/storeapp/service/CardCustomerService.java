package com.store.storeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storeapp.models.CardCustomer;
import com.store.storeapp.models.Customer;
import com.store.storeapp.repository.CardCustomerRepository;

@Service
public class CardCustomerService {

	@Autowired
	private CardCustomerRepository cardCustomerRepository;
		
	public List<CardCustomer> getAllCardByCustomer(Customer customer){
		return cardCustomerRepository.getCardCustomerByCustomer(customer);
	}
	
	public CardCustomer setCardCustomer(CardCustomer card) {
		return cardCustomerRepository.save(card);
	}
	
	public boolean deleteCardCustomer(Customer customer, CardCustomer cardCustomer) {
		List<CardCustomer> card = cardCustomerRepository.getCardCustomerByCustomer(customer); 
		if(card.contains(cardCustomer)) {
			cardCustomerRepository.delete(cardCustomer);
			return true;
		}
		return false;
	}	
}
