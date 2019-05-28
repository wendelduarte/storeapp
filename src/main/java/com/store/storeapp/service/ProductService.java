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
			return productRepository.findById(id)
					.map(record -> {
						record.setProductType(updateProduct.getProductType());
						record.setName(updateProduct.getName());
						record.setBrand(updateProduct.getBrand());
						record.setPrice(updateProduct.getPrice());
						record.setDescription(updateProduct.getDescription());
						Product updated = productRepository.save(record);
						return updated;
					});
		}
		return null;
	}
	
	//ordena produto por menor preço
	public List<Product> orderByPriceAsc(){
		return productRepository.getProductOrderByPrice();
	}
	
	//ordena produto por maior preço
	public List<Product> orderByPriceDesc(){
		return productRepository.getProductOrderByPriceDesc();
	}
	
	public List<Product> searchProduct(String name){
		return productRepository.getByName(name);
	}
	
	//deleta
	public boolean deleteProduct(Long id) {
		if(getOneProduct(id) != null) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

}