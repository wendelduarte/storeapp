package com.store.storeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storeapp.models.ProductType;
import com.store.storeapp.repository.ProductTypeRepository;

@Service
public class ProductTypeService {
	
	@Autowired
	public ProductTypeRepository productTypeRepository;
	
	public List<ProductType> getAllProductType(){
		return productTypeRepository.findAll();
	}
	
	public Optional<ProductType> getOneProductType(Long id){
		return productTypeRepository.findById(id);
	}
	
	public ProductType setProductType(ProductType productType) {
		return productTypeRepository.save(productType);
	}
}
