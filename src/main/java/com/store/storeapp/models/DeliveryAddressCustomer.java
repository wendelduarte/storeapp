package com.store.storeapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class DeliveryAddressCustomer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long deliveryAddressId;
	
	//FK customer
	@ManyToOne
	private Customer customerId; 
	
	@NonNull
	@Column(length=100)
	private String customerAddress;
	
	@Column(length=20)
	private String customerCity;
	
	@NonNull
	@Column(length=2)
	private String customerState;
	
	@NonNull
	private long cepCustomer;
	
	private String complementAddressCustomer;
	
	//construct
	public DeliveryAddressCustomer() {}

	//getters and setters
	public long getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public void setDeliveryAddressId(long deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public long getCepCustomer() {
		return cepCustomer;
	}

	public void setCepCustomer(long cepCustomer) {
		this.cepCustomer = cepCustomer;
	}

	public String getComplementAddressCustomer() {
		return complementAddressCustomer;
	}

	public void setComplementAddressCustomer(String complementAddressCustomer) {
		this.complementAddressCustomer = complementAddressCustomer;
	}

}
