package com.store.storeapp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	
	@NonNull
	@ManyToOne
	private ProductType productType;
	
	@ManyToOne
	private ConfirmOrder order;
	
	@ManyToMany
	private List<ProviderProduct> providers;
	
	@NonNull
	@Column(length=30)
	private String name;
	
	@NonNull
	@Column(length=30)
	private String brand;
	
	@NonNull
	private float price;
	
	private String description;
	
	//construct
	public Product() {}
	
	public Product(long productId, ProductType productType, ConfirmOrder order, List<ProviderProduct> providers,
			String name, String brand, float price, String description) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.order = order;
		this.providers = providers;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.description = description;
	}

	public Product(long productId) {
		super();
		this.productId = productId;
	}

	//getters and setters
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	public ConfirmOrder getOrder() {
		return order;
	}
	public void setOrder(ConfirmOrder order) {
		this.order = order;
	}
	
	public List<ProviderProduct> getProviders() {
		return providers;
	}

	public void setProviders(List<ProviderProduct> providers) {
		this.providers = providers;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
