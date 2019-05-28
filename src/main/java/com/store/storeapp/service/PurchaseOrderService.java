package com.store.storeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storeapp.models.Customer;
import com.store.storeapp.models.PurchaseOrder;
import com.store.storeapp.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {
	
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	public List<PurchaseOrder> getAllPurchaseOrderByCustomer (Customer customer){
		purchaseOrderRepository.totalPrice(customer);
		return purchaseOrderRepository.getAllPurchaseOrderByCustomer(customer);
	}
	
	public Optional<PurchaseOrder> getOnePurchaseOrderByCustomer(Customer customer, PurchaseOrder purchaseOrder){
		List<PurchaseOrder> allPurchaseOrder = getAllPurchaseOrderByCustomer(customer);
		
		if(allPurchaseOrder.contains(purchaseOrder)) {
			int index = allPurchaseOrder.indexOf(purchaseOrder);
			return Optional.of(allPurchaseOrder.get(index));
		}
		return Optional.empty();
	}
	
	public PurchaseOrder setPurchaseOrder(PurchaseOrder order) {
		return purchaseOrderRepository.save(order);
	}
}
