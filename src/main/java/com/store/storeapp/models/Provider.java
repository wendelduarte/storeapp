package com.store.storeapp.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Provider {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long providerId;
		
	@NotNull
	@Column(length=50)
	private String businessName;
	
	@NotNull
	@Column(length=20)
	private String tradeName;
	
	@NotNull
	private String cnpj;
	
	private String ie;
	
	
	@NotNull
	@Column(length=2)
	private String providerState;
	
	@NotNull
	private String providerAddress;
	@NotNull
	private String providerCity;
	
	@NotNull
	private String contactName;
	
	@NotNull
	private String telProvider;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Provider_Product", joinColumns = { @JoinColumn(name = "providerId")}, inverseJoinColumns = { @JoinColumn(name = "productId")})
	private Set<Product> product;
		
	//construct
	public Provider() {}

	//getters and setters
	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
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

	public String getTelProvider() {
		return telProvider;
	}

	public void setTelProvider(String telProvider) {
		this.telProvider = telProvider;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
}
