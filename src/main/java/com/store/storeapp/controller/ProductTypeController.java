package com.store.storeapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.Utils;
import com.store.storeapp.models.ProductType;
import com.store.storeapp.service.ProductTypeService;

@RestController
public class ProductTypeController {
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@Autowired
	private Utils utilM;
	
	@GetMapping("/productType")
	public ResponseEntity<List<?>> getAllProductType(){
		List<ProductType> allType = productTypeService.getAllProductType();
		return utilM.getAll(allType);
	}
	
	@GetMapping("/productType/{id}")
	public ResponseEntity<Optional<?>> getOneProductType(@PathVariable Long id){
		Optional<ProductType> type = productTypeService.getOneProductType(id);
		return utilM.getOne(type);
	}
	
	@PostMapping("/productType")
	public ProductType setProductType(@RequestBody ProductType newType) {
		return productTypeService.setProductType(newType);
	}
}
