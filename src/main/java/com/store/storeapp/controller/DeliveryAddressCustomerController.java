package com.store.storeapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin
	@GetMapping("/address/{customer}")
	public ResponseEntity<List<?>> getAllDeliveryAddressByCustomer(@PathVariable Customer customer){
		List<DeliveryAddressCustomer> address = dacService.getAllDeliveryAddressByCustomer(customer);
		return utilM.getAll(address);
	}
	
	@CrossOrigin
	@GetMapping("/address/{customer}/{deliveryCustomer}")
	public ResponseEntity<Optional<?>> getOneDeliveryAddressByCustomer(@PathVariable Customer customer, @PathVariable DeliveryAddressCustomer deliveryCustomer){
		Optional<DeliveryAddressCustomer> address = dacService.getOneDeliveryAddressByCustomer(customer, deliveryCustomer);
		return utilM.getOne(address);
	}
	
	@CrossOrigin
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/address")
	public DeliveryAddressCustomer setDeliveryAddressCustomer(@RequestBody DeliveryAddressCustomer deliveryAddress) {
		return dacService.setDeliveryAddress(deliveryAddress);
	}
	
	@CrossOrigin
	@PutMapping("/address/{customer}/{addressId}")
	public ResponseEntity<Optional<?>> updateAddress(@PathVariable Long addressId, @PathVariable Customer customer, @RequestBody DeliveryAddressCustomer updateDeliveryAddress){
		Optional<DeliveryAddressCustomer> address = dacService.updateDeliveryAddress(addressId, customer, updateDeliveryAddress);
		return utilM.update(address);
	}
	
	@CrossOrigin
	@DeleteMapping("/address/{customer}/{deliveryCustomer}")
	public ResponseEntity<?> deleteDeliveryAddres(@PathVariable Customer customer, @PathVariable DeliveryAddressCustomer deliveryCustomer){
		boolean address = dacService.deleteDeliveryAddres(customer, deliveryCustomer);
		return utilM.delete(address);
	}
}
