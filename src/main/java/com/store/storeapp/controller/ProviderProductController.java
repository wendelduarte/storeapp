package com.store.storeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.Utils;
import com.store.storeapp.models.Provider;
import com.store.storeapp.models.ProviderProduct;
import com.store.storeapp.service.ProviderProductService;

@RestController
public class ProviderProductController {

	@Autowired
	private ProviderProductService providerProductService;
	
	@Autowired
	private Utils utilM;
	
	@GetMapping("/provider/product/{providerId")
	public ResponseEntity<List<?>> getProviderProductByProviderId(@PathVariable Provider providerId){
		List<ProviderProduct> providerProduct = providerProductService.getProviderProductByProviderId(providerId);
		return utilM.getAll(providerProduct);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("provider/product")
	public ProviderProduct setProviderProduct(ProviderProduct providerProduct) {
		return providerProductService.setProviderProduct(providerProduct);
	}
	
	@DeleteMapping("/providerProduct/{providerId}/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Provider providerId, @PathVariable ProviderProduct id){
		boolean providerProduct = providerProductService.deleteProviderProduct(providerId, id);
		return utilM.delete(providerProduct);
	}
}
