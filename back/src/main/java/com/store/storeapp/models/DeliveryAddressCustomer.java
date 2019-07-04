package com.store.storeapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class DeliveryAddressCustomer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long deliveryAddressId;
	
	//FK customer
	@ManyToOne
	@JoinColumn(name="CUSTOMER_FK")
	private Customer customer;
	
	private String customerAddress;	
	
	private String customerCity;
	
	@Column(length=2)
	private String customerState;
	
	private String cepCustomer;
	
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
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomerId(Customer customer) {
		this.customer = customer;
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

	public String getCepCustomer() {
		return cepCustomer;
	}

	public void setCepCustomer(String cepCustomer) {
		this.cepCustomer = cepCustomer;
	}

	public String getComplementAddressCustomer() {
		return complementAddressCustomer;
	}

	public void setComplementAddressCustomer(String complementAddressCustomer) {
		this.complementAddressCustomer = complementAddressCustomer;
	}

}
