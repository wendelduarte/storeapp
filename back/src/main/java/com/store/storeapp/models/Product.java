package com.store.storeapp.models;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "product")
	private Set<ProductOrder> productOrder;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="PRODUCT_TYPE_FK")
	private ProductType productType;
	
	@ManyToOne
	@JoinColumn(name="providers")
	private Provider provider;
	
	@NotNull
	@Column(length=30)
	private String name;
	

	@NotNull
	@Column(length=30)
	private String brand;
	
	@NotNull
	private Float price;
	
	private String description;
	
	//construct
	public Product() {}

	public Product(long productId, Set<ProductOrder> productOrder, ProductType productType,
			String name, String brand, Float price, String description) {
		super();
		this.productId = productId;
		this.productOrder = productOrder;
		this.productType = productType;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.description = description;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
	public Set<ProductOrder> getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(Set<ProductOrder> productOrder) {
		this.productOrder = productOrder;
	}

	
	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
