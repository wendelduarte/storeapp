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
	
	public List<DeliveryAddressCustomer> getAllDeliveryAddressByCustomer(Customer customer){
		return dacRepository.getDeliveryAddresByCustomer(customer);
	}
	
	public Optional<DeliveryAddressCustomer> getOneDeliveryAddressByCustomer(Customer customer, DeliveryAddressCustomer deliveryCustomer){
		List<DeliveryAddressCustomer> deliveryAddressCustomer = getAllDeliveryAddressByCustomer(customer);
		
		if(deliveryAddressCustomer.contains(deliveryCustomer)) {
			int index = deliveryAddressCustomer.indexOf(deliveryCustomer);
			return Optional.of(deliveryAddressCustomer.get(index));
		}
		return Optional.empty();
	}
	
	public DeliveryAddressCustomer setDeliveryAddress(DeliveryAddressCustomer deliveryAddress) {
		return dacRepository.save(deliveryAddress);
	}
	
	public Optional<DeliveryAddressCustomer> updateDeliveryAddress(Long addressId, Customer customer,  DeliveryAddressCustomer deliveryCustomer) {
		Optional<DeliveryAddressCustomer> address = dacRepository.findById(addressId);
		if(address.isPresent()) {
			return dacRepository.findById(addressId)
					.map(record -> {
						record.setCustomerAddress(deliveryCustomer.getCustomerAddress());
						record.setCustomerCity(deliveryCustomer.getCustomerCity());
						record.setCustomerState(deliveryCustomer.getCustomerState());
						record.setCepCustomer(deliveryCustomer.getCepCustomer());
						record.setComplementAddressCustomer(deliveryCustomer.getComplementAddressCustomer());
						DeliveryAddressCustomer updated = dacRepository.save(record);
						return updated;
					});
		}
		return null;
	}
	
	public boolean deleteDeliveryAddres (Customer customer, DeliveryAddressCustomer deliveryCustomer) {
		List<DeliveryAddressCustomer> address = getAllDeliveryAddressByCustomer(customer);
		if(address.contains(deliveryCustomer)) {
			dacRepository.delete(deliveryCustomer);
			return true;
		}
		return false;
	}
}
