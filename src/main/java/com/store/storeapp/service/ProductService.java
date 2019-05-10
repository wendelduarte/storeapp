package com.store.storeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	//atualiza
	public Optional<Product> updateProduct(Product updateProduct, Long id) {
		Optional<Product> product = getOneProduct(id);
		if(product.isPresent()) {
			return product = Optional.of(productRepository.save(updateProduct));
		}
		return null;
	}
	
	//deleta
	public boolean deleteProduct(Product id) {
		List<Product> product = getAllProducts();
		if(product.contains(id)) {
			productRepository.delete(id);
			return true;
		}
		return false;
	}

}