package com.store.storeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.models.Provider;
import com.store.storeapp.service.ProviderService;

@RestController
public class ProviderController {

	@Autowired
	private ProviderService providerService;
	
	@GetMapping("/provider")
	public List<Provider> getAllProviders(){
		return providerService.getAllProvider();
	}
	
	@PostMapping("/provider/post")
	public void setProvider (@RequestBody Provider provider) {
		providerService.setProvider(provider);
	}
	
	@PutMapping("/provider/att/{id}")
	public void updateProvider(@PathVariable Long id, @RequestBody Provider update) {
		providerService.updateProvider(update);
	}
	
	@DeleteMapping("/provider/{id}")
	public void deleteProvider(@PathVariable Provider id) {
		providerService.deleteProvider(id);
	}
}
