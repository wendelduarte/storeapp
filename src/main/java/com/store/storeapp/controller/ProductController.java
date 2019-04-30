package com.store.storeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.models.Product;
import com.store.storeapp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public List<Product> allProducts(){
		return productService.getAllProducts();
	}
	

	
}
