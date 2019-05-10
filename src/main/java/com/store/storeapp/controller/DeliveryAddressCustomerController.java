package com.store.storeapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.Utils;
import com.store.storeapp.models.Customer;
import com.store.storeapp.models.DeliveryAddressCustomer;
import com.store.storeapp.service.DeliveryAddressCustomerService;


//dacService é uma instância do DeliveryAddressCustomerService
@RestController
public class DeliveryAddressCustomerController {
	
	@Autowired
	private DeliveryAddressCustomerService dacService;
	
	@Autowired
	private Utils utilM;
	
	@GetMapping("/address/{customerId}")
	public ResponseEntity<List<?>> getAllDeliveryAddressByCustomerId(@PathVariable Customer customerId){
		List<DeliveryAddressCustomer> address = dacService.getAllDeliveryAddressByCustomerId(customerId);
		return utilM.getAll(address);
	}
	
	@GetMapping("/address/{customerId}/{id}")
	public ResponseEntity<Optional<?>> getOneDeliveryAddressByCustomerId(@PathVariable Customer customerId, @PathVariable DeliveryAddressCustomer id){
		Optional<DeliveryAddressCustomer> address = dacService.getOneDeliveryAddressByCustomerId(customerId, id);
		return utilM.getOne(address);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/addres")
	public DeliveryAddressCustomer setDeliveryAddressCustomer(DeliveryAddressCustomer deliveryAddress) {
		return dacService.setDeliveryAddress(deliveryAddress);
	}
	
	@PutMapping("/address/{customerId}/{id}")
	public ResponseEntity<Optional<?>> updateAddress(@RequestBody DeliveryAddressCustomer updateDeliveryAddress, @PathVariable Customer customerId, @PathVariable DeliveryAddressCustomer id){
		Optional<DeliveryAddressCustomer> address = dacService.updateDeliveryAddress(updateDeliveryAddress, customerId, id);
		return utilM.update(address);
	}
	
	@DeleteMapping("/address/{customerId}/{id}")
	public ResponseEntity<?> deleteDeliveryAddres(@PathVariable Customer customerId, @PathVariable DeliveryAddressCustomer id){
		boolean address = dacService.deleteDeliveryAddres(customerId, id);
		return utilM.delete(address);
	}
}
