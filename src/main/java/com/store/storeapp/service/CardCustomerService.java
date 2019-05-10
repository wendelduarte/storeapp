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
		
	public List<CardCustomer> getAllCardByCustomerId(Customer customerId){
		return cardCustomerRepository.getCardCustomerByCustomerId(customerId);
	}
	
	public CardCustomer setCardCustomer(CardCustomer card) {
		return cardCustomerRepository.save(card);
	}
	
	public boolean deleteCardCustomer(Customer customerId, CardCustomer id) {
		List<CardCustomer> card = cardCustomerRepository.getCardCustomerByCustomerId(customerId); 
		if(card.contains(id)) {
			cardCustomerRepository.delete(id);
			return true;
		}
		return false;
	}	
}
