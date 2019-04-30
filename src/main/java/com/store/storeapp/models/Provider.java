package com.store.storeapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.lang.NonNull;

@Entity
public class Provider {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long providerId;
	
	@ManyToMany
	private List<ProviderProduct> products;
	
	@NonNull
	@Column(length=50)
	private String businessName;
	
	@NonNull
	@Column(length=20)
	private String tradeName;
	
	@NonNull
	private long cnpj;
	private long ie;
	
	@NonNull
	private String providerAddress;
	
	@NonNull
	private String providerCity;
	
	@NonNull
	@Column(length=2)
	private String providerState;
	
	@NonNull
	private String email;
	
	@NonNull
	private String password;
	
	private long telProvider;
	
	@NonNull
	private String contactName;
		
	//construct
	public Provider() {}

	//getters and setters
	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public List<ProviderProduct> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ProviderProduct> products) {
		this.products = products;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public long getIe() {
		return ie;
	}

	public void setIe(long ie) {
		this.ie = ie;
	}

	public String getProviderAddress() {
		return providerAddress;
	}

	public void setProviderAddress(String providerAddress) {
		this.providerAddress = providerAddress;
	}

	public String getProviderCity() {
		return providerCity;
	}

	public void setProviderCity(String providerCity) {
		this.providerCity = providerCity;
	}

	public String getProviderState() {
		return providerState;
	}

	public void setProviderState(String providerState) {
		this.providerState = providerState;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getTelProvider() {
		return telProvider;
	}

	public void setTelProvider(long telProvider) {
		this.telProvider = telProvider;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
}
