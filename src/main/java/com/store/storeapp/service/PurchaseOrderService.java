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
	
	public List<PurchaseOrder> getAllPurchaseOrderByCustomerId (Customer customerId){
		return purchaseOrderRepository.getAllPurchaseOrderByCustomerId(customerId);
	}
	
	public Optional<PurchaseOrder> getOnePurchaseOrderCustomerId(Customer customerId, PurchaseOrder id){
		List<PurchaseOrder> purchaseOrder = getAllPurchaseOrderByCustomerId(customerId);
		
		if(purchaseOrder.contains(id)) {
			int index = purchaseOrder.indexOf(id);
			return Optional.of(purchaseOrder.get(index));
		}
		return Optional.empty();
	}
	
	public PurchaseOrder setPurchaseOrder(PurchaseOrder order) {
		return purchaseOrderRepository.save(order);
	}
}
