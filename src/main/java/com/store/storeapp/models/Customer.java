	package com.store.storeapp.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerId;
	
	@NonNull
	@Column(length=30)
	private String name;
	
	@NonNull
	@Column(length=30)
	private String email;
	
	@NonNull
	private String password;
	
	@NonNull
	private long cpfCustomer;
	
	@NonNull
	private Date dateBirthCustomer;
	
	private Long telCustomer;
	
	@NonNull
	private long celCustomer;
	
	@NonNull
	private String bilingAddres;
	
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
	public long getCpfCustomer() {
		return cpfCustomer;
	}
	public void setCpfCustomer(long cpfCustomer) {
		this.cpfCustomer = cpfCustomer;
	}
	public Date getDateBirthCustomer() {
		return dateBirthCustomer;
	}
	public void setDateBirthCustomer(Date dateBirthCustomer) {
		this.dateBirthCustomer = dateBirthCustomer;
	}
	public Long getTelCustomer() {
		return telCustomer;
	}
	public void setTelCustomer(Long telCustomer) {
		this.telCustomer = telCustomer;
	}
	public long getCelCustomer() {
		return celCustomer;
	}
	public void setCelCustomer(long celCustomer) {
		this.celCustomer = celCustomer;
	}
	public String getBilingAddres() {
		return bilingAddres;
	}
	public void setBilingAddres(String bilingAddres) {
		this.bilingAddres = bilingAddres;
	}

	public Set<CardCustomer> getCardCustomer() {
		return cardCustomer;
	}

	public void setCardCustomer(Set<CardCustomer> cardCustomer) {
		this.cardCustomer = cardCustomer;
	}

	public Set<DeliveryAddressCustomer> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Set<DeliveryAddressCustomer> customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Set<PurchaseOrder> getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(Set<PurchaseOrder> purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
}
