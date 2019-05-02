package com.store.storeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.store.storeapp.models.Product;
import com.store.storeapp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	//busca todos
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	//busca apenas um
	
	public Optional<Product> getOneProduct(Long id) {
		return productRepository.findById(id);
	}	
	
	//salva novo
	public Product setProduct(Product product) {
		return productRepository.save(product);
	}
	/*
	//atualiza
	public Product updateProduct(Product updateProduct, Long id) {
		return productRepository.findById(id)
				.map(product -> {
					product.setProductType(updateProduct.getProductType());
					product.setOrder(updateProduct.getOrder());
					product.setProviders(updateProduct.getProviders());
					product.setName(updateProduct.getName());
					product.setBrand(updateProduct.getBrand());
					product.setPrice(updateProduct.getPrice());
					product.setDescription(updateProduct.getDescription());
				}).orElseGet(() -> {
					updateProduct.setProductId(id);
					return productRepository.save(updateProduct);
				});
	}
	*/
	//deleta
	public void deleteProduct(Product id) {
		productRepository.delete(id);
	}

}