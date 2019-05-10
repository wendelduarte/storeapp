package com.store.storeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storeapp.models.Customer;
import com.store.storeapp.models.DeliveryAddressCustomer;
import com.store.storeapp.repository.DeliveryAddressCustomerRepository;

//dacRepository é uma instancia do DeliveryAddressCustomerRepository
@Service
public class DeliveryAddressCustomerService {
	
	@Autowired
	private DeliveryAddressCustomerRepository dacRepository;
	
	public List<DeliveryAddressCustomer> getAllDeliveryAddressByCustomerId(Customer customerId){
		return dacRepository.getDeliveryAddresByCustomerId(customerId);
	}
	
	public Optional<DeliveryAddressCustomer> getOneDeliveryAddressByCustomerId(Customer customerId, DeliveryAddressCustomer id){
		List<DeliveryAddressCustomer> deliveryAddressCustomer = getAllDeliveryAddressByCustomerId(customerId);
		
		if(deliveryAddressCustomer.contains(id)) {
			int index = deliveryAddressCustomer.indexOf(id);
			return Optional.of(deliveryAddressCustomer.get(index));
		}
		return Optional.empty();
	}
	
	public DeliveryAddressCustomer setDeliveryAddress(DeliveryAddressCustomer deliveryAddress) {
		return dacRepository.save(deliveryAddress);
	}
	
	public Optional<DeliveryAddressCustomer> updateDeliveryAddress(DeliveryAddressCustomer updateDeliveryAddress, Customer customerId,  DeliveryAddressCustomer id) {
		Optional<DeliveryAddressCustomer> address = getOneDeliveryAddressByCustomerId(customerId, id);
		if(address.isPresent()) {
			return address = Optional.of(dacRepository.save(updateDeliveryAddress));
		}
		return null;
	}
	
	public boolean deleteDeliveryAddres (Customer customerId, DeliveryAddressCustomer id) {
		List<DeliveryAddressCustomer> address = getAllDeliveryAddressByCustomerId(customerId);
		if(address.contains(id)) {
			dacRepository.delete(id);
			return true;
		}
		return false;
	}
}
