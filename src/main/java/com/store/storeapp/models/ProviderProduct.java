package com.store.storeapp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ProviderProduct {
	
	@Id
	@GeneratedValue
	private Integer idProviderProduct;
	
	@ManyToMany
	private List<Product> products;
	
	@ManyToMany
	private List<Provider> providers;
	
	//construct
	public ProviderProduct() {}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	//getters and setters
	
	
}

