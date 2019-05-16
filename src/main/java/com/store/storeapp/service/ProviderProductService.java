package com.store.storeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storeapp.models.Provider;
import com.store.storeapp.models.ProviderProduct;
import com.store.storeapp.repository.ProviderProductRepository;

@Service
public class ProviderProductService {

	@Autowired
	public ProviderProductRepository providerProductRepository;
	
	public List<ProviderProduct> getProviderProductByProviderId(Provider providerId){
		return providerProductRepository.getProviderProductByProviderId(providerId);
	}
	
	public ProviderProduct setProviderProduct(ProviderProduct providerProduct) {
		return providerProductRepository.save(providerProduct);
	}
	
	public boolean deleteProviderProduct(Provider providerId, ProviderProduct id) {
		List<ProviderProduct> providerProduct = providerProductRepository.getProviderProductByProviderId(providerId); 
		if(providerProduct.contains(id)) {
			providerProductRepository.delete(id);
			return true;
		}
		return false;
	}
}
