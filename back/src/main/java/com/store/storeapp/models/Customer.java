package com.store.storeapp.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerId;
	
	@NotNull
	@Column(length=30)
	private String name;
	
	@NotNull
	@Column(length=20)
	private String cpfCustomer;
	
	private String dateBirthCustomer;
	
	private String telCustomer;
	
	private String celCustomer;	
	
	@NotNull
	@Column(length=30)
	private String email;
	
	@NotNull
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "customer")
	private Set<CardCustomer> cardCustomer;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "customer")
	private Set<DeliveryAddressCustomer> customerAddress;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "customer")
	private Set<PurchaseOrder> purchaseOrder;
	
	//construct
	public Customer() {}
	
	//getters and setters
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId=customerId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	public String getCpfCustomer() {
		return cpfCustomer;
	}
	public void setCpfCustomer(String cpfCustomer) {
		this.cpfCustomer = cpfCustomer;
	}
	public String getDateBirthCustomer() {
		return dateBirthCustomer;
	}
	public void setDateBirthCustomer(String dateBirthCustomer) {
		this.dateBirthCustomer = dateBirthCustomer;
	}
	public String getTelCustomer() {
		return telCustomer;
	}
	public void setTelCustomer(String telCustomer) {
		this.telCustomer = telCustomer;
	}
	public String getCelCustomer() {
		return celCustomer;
	}
	public void setCelCustomer(String celCustomer) {
		this.celCustomer = celCustomer;
	}

	public Set<CardCustomer> getCardCustomer() {
		return cardCustomer;
	}

	public void setCardCustomer(Set<CardCustomer> cardCustomer) {
		this.cardCustomer = cardCustomer;
	}

	//@JsonIgnore
	public Set<DeliveryAddressCustomer> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Set<DeliveryAddressCustomer> customerAddress) {
		this.customerAddress = customerAddress;
	}

	@JsonIgnore
	public Set<PurchaseOrder> getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(Set<PurchaseOrder> purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
}
