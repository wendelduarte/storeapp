package com.store.storeapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProviderProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProviderProduct;
	
	@OneToOne
	private Product productId;
	
	@OneToOne
	private Provider providerId;
	
	//construct
	public ProviderProduct() {}

	public Integer getIdProviderProduct() {
		return idProviderProduct;
	}

	public void setIdProviderProduct(Integer idProviderProduct) {
		this.idProviderProduct = idProviderProduct;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Provider getProviderId() {
		return providerId;
	}

	public void setProviderId(Provider providerId) {
		this.providerId = providerId;
	}

	
}

