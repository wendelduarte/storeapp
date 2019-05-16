package com.store.storeapp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	
	@NonNull
	@ManyToOne
	private ProductType productType;
	
	@OneToMany
	private List<ProductOrder> productOrder;
	
	@ManyToMany
	private List<Provider> provider;
	
	@NonNull
	@Column(length=30)
	private String name;
	
	@NonNull
	@Column(length=30)
	private String brand;
	
	@NonNull
	private Float price;
	
	private String description;
	
	//construct
	public Product() {}
	
	

	public Product(long productId, ProductType productType, List<ProductOrder> productOrder,
			String name, String brand, Float price, String description) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.productOrder = productOrder;
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
	
	public List<ProductOrder> getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(List<ProductOrder> productOrder) {
		this.productOrder = productOrder;
	}
	
	public List<Provider> getProvider() {
		return provider;
	}
	
	public void setProvider(List<Provider> provider) {
		this.provider = provider;
	}

	public void setPrice(Float price) {
		this.price = price;
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
