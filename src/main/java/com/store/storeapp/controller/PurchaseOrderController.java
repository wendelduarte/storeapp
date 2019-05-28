package com.store.storeapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.Utils;
import com.store.storeapp.models.Customer;
import com.store.storeapp.models.PurchaseOrder;
import com.store.storeapp.service.PurchaseOrderService;

@RestController
public class PurchaseOrderController {
	
	@Autowired
	private PurchaseOrderService purchaseOrderService;
	
	@Autowired
	private Utils utilM;
	
	@GetMapping("/order/{customer}")
	public ResponseEntity<List<?>> getAllPurchaseOrderByCustomer(@PathVariable Customer customer){
		List<PurchaseOrder> order = purchaseOrderService.getAllPurchaseOrderByCustomer(customer);
		return utilM.getAll(order);
	}
	
	@GetMapping("/order/{customer}/{purchaseOrder}")
	public ResponseEntity<Optional<?>> getOnePurchaseOrderByCustomer (@PathVariable Customer customer, @PathVariable PurchaseOrder purchaseOrder){
		Optional<PurchaseOrder> order = purchaseOrderService.getOnePurchaseOrderByCustomer(customer, purchaseOrder);
		return utilM.getOne(order);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/order")
	public PurchaseOrder setPurchaseOrder(PurchaseOrder order) {
		return purchaseOrderService.setPurchaseOrder(order);
	}
}
