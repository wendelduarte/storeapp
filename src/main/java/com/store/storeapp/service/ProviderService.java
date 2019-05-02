package com.store.storeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storeapp.models.Provider;
import com.store.storeapp.repository.ProviderRepository;

@Service
public class ProviderService {
	
	@Autowired
	private ProviderRepository providerRepository;
	
	public List<Provider> getAllProvider(){
		return providerRepository.findAll();
	}
	
	public void setProvider(Provider provider) {
		providerRepository.save(provider);
	}
	
	public void updateProvider(Provider id) {
		providerRepository.save(id);
	}
	
	public void deleteProvider(Provider id) {
		providerRepository.delete(id);
	}
}
