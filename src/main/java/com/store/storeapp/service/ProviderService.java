package com.store.storeapp.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Provider> getOneProvider(Long id){
		return providerRepository.findById(id);
	}
	
	public void setProvider(Provider provider) {
		providerRepository.save(provider);
	}
	
	public Optional<Provider> updateProvider(Provider updateProvider, Long id) {
		Optional<Provider> provider = getOneProvider(id);
		if(provider.isPresent()) {
			return provider = Optional.of(providerRepository.save(updateProvider));
		} else {
			return null;
		}
	} 
	
	public boolean deleteProvider(Provider provider) {
		List<Provider> allProvider = getAllProvider();
		if(allProvider.contains(provider)) {
			providerRepository.delete(provider);
			return true;
		} else {
			return false;
		}
	}
	
	public String getPasswordByEmail(String email) {
		Provider provider = providerRepository.findByEmail(email);
		return provider.getPassword();
	}
	
	public Provider findByEmail(String email) {
		return providerRepository.findByEmail(email);
	}
}
