package com.store.storeapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.Utils;
import com.store.storeapp.models.Product;
import com.store.storeapp.models.ProductType;
import com.store.storeapp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private Utils utilM;
	
	@CrossOrigin
	@GetMapping("/product")
	public ResponseEntity<List<?>> getAllProducts(){
		List<Product> allProducts = productService.getAllProducts();
		return utilM.getAll(allProducts);
	}
	@CrossOrigin
	@GetMapping("/product/{id}")
	public ResponseEntity<Optional<?>> getOneProduct(@PathVariable Long id){
		Optional<Product> product = productService.getOneProduct(id);
		return utilM.getOne(product);
	}
	
	@CrossOrigin
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/product/filter/asc")
	public List<Product> orderByPrice(){
		return productService.orderByPriceAsc();
	}
	
	@CrossOrigin
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/product/filter/desc")
	public List<Product> orderByPriceDesc(){
		return productService.orderByPriceDesc();
	}
	
	@CrossOrigin
	@GetMapping("/product/filter/{type}/{name}")
	public ResponseEntity<List<?>> findByNameAndType(@PathVariable ProductType type, @PathVariable String name){
		List<Product> products = productService.findByNameAndType(type, name);
		return utilM.searchProduct(products);
	}
	
	@CrossOrigin
	@GetMapping("/product/search/{name}")
	public ResponseEntity<List<?>> searchProduct(@PathVariable String name){
		List<Product> products = productService.searchProduct(name);
		return utilM.searchProduct(products);
	}
	
	@CrossOrigin
	@GetMapping("/product/filter/{type}")
	public List<Product> typeProduct(@PathVariable ProductType type){
		return productService.filterType(type);
	}
	
	@CrossOrigin
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/product")
	public Product postProduct(@RequestBody Product newProduct) {
		return productService.setProduct(newProduct);
	}
	
	@CrossOrigin
	@PutMapping("/product/{id}")
	public ResponseEntity<Optional<?>> updateProduct(@RequestBody Product update, @PathVariable Long id) {
		Optional<Product> product = productService.updateProduct(update, id);
		return utilM.update(product);
	}
	
	@CrossOrigin
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id){
		boolean product = productService.deleteProduct(id); 
		return utilM.delete(product);
	}

}
