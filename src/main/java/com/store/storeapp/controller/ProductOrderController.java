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
import com.store.storeapp.models.ProductOrder;
import com.store.storeapp.service.ProductOrderService;

@RestController
public class ProductOrderController {
	
	@Autowired
	private ProductOrderService productOrderService;
	
	@Autowired
	private Utils utilM;
	
	@GetMapping("/productorder")
	public ResponseEntity<List<?>> getAllProductOrder(){
		List<ProductOrder> allProductOrder = productOrderService.getAllProductOrder();
		return utilM.getAll(allProductOrder);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/productorder")
	public ProductOrder postProductOrder(@RequestBody ProductOrder newProductOrder) {
		return productOrderService.setProductOrder(newProductOrder);
	}
	
	@PutMapping("/productorder/{id}")
	public ResponseEntity<Optional<?>> updateProductOrder(@RequestBody ProductOrder update, @PathVariable Long id) {
		Optional<ProductOrder> productOrder = productOrderService.updateProductOrder(update, id);
		return utilM.update(productOrder);
	}
	
	@DeleteMapping("/productorder/{productOrderId}")
	public ResponseEntity<?> deleteProductOrder(@PathVariable Long productOrderId){
		boolean value = productOrderService.deleteProductOrder(productOrderId); 
		return utilM.delete(value);
	}	
}
