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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.models.Product;
import com.store.storeapp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> product = productService.getAllProducts();
		
		if(product.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Optional<Product>> getOneProduct(@PathVariable Long id){
		Optional<Product> product = productService.getOneProduct(id);
		
		if(product.isPresent()) {
			return new ResponseEntity<Optional<Product>>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/product/post")
	public Product postProduct(@RequestBody Product newProduct) {
		return productService.setProduct(newProduct);
		
	}
	/*
	@PutMapping("/product/att/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product update) {
		return productService.updateProduct(update, id);
	}
	*/
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Product id){
		List<Product> product = productService.getAllProducts();
		
		if(product.contains(id)) {
			productService.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}	
}
