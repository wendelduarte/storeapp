package com.store.storeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storeapp.models.ProductOrder;
import com.store.storeapp.repository.ProductOrderRepository;

@Service
public class ProductOrderService {
	
	@Autowired
	public ProductOrderRepository productOrderRepository;
	
	public List<ProductOrder> getAllProductOrder (){
		return productOrderRepository.findAll();
	}
	
	public ProductOrder setProductOrder(ProductOrder productOrder) {
		return productOrderRepository.save(productOrder);
	}	
	
	public Optional<ProductOrder> getOneProductOrder(Long id) {
		return productOrderRepository.findById(id);
	}
	
	public Optional<ProductOrder> updateProductOrder(ProductOrder updateProductOrder, Long id) {
		Optional<ProductOrder> productOrder = getOneProductOrder(id);
		if(productOrder.isPresent()) {
			return productOrder = Optional.of(productOrderRepository.save(updateProductOrder));
		}
		return null;
	}
	
	public boolean deleteProductOrder(ProductOrder productOrder) {
		List<ProductOrder> allProductOrder = getAllProductOrder();
		if(allProductOrder.contains(productOrder)) {
			productOrderRepository.delete(productOrder);
			return true;
		}
		return false;
	}

	public float totalOfProduct() {
		return productOrderRepository.totalOfProduct();
	}

}
