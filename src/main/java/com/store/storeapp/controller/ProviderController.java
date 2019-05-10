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
import com.store.storeapp.models.Provider;
import com.store.storeapp.service.ProviderService;

@RestController
public class ProviderController {

	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private Utils utilM;
	
	@GetMapping("/provider")
	public ResponseEntity<List<?>> getAllProviders(){
		List<Provider> allProviders = providerService.getAllProvider();
		return utilM.getAll(allProviders);		 
	}
	
	@GetMapping("/provider/{id}")
	public ResponseEntity<Optional<?>> getOneProvider(@PathVariable Long id){
		Optional<Provider> provider = providerService.getOneProvider(id);
		return utilM.getOne(provider);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/provider/post")
	public void setProvider (@RequestBody Provider provider) {
		providerService.setProvider(provider);
	}
	
	
	@PutMapping("/provider/{id}")
	public ResponseEntity<Optional<?>> updateProvider(@RequestBody Provider update, @PathVariable Long id) {
		Optional<Provider> provider= providerService.updateProvider(update, id);
		return utilM.update(provider);
	}
	
	@DeleteMapping("/provider/{id}")
	public ResponseEntity<?> deleteProvider(@PathVariable Provider id) {
		boolean provider = providerService.deleteProvider(id);
		return utilM.delete(provider);
	}
}
