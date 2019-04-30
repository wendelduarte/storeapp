package com.store.storeapp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	@OneToMany
	private List<DeliveryAddressCustomer> address;
	
	@OneToMany
	private List<CardCustomer> creditCard;
	
	@OneToMany
	private List<PurchaseOrder> purchase;
	
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
	
	//construct
	public Customer() {}
	
	//getters and setters
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId=customerId;
	}
	
	public List<DeliveryAddressCustomer> getAddress(){
		return address;
	}
	public void setAddress(List<DeliveryAddressCustomer> address){
		this.address=address;
	
	}
	public List<CardCustomer> getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(List<CardCustomer> creditCard) {
		this.creditCard = creditCard;
	}
	
	public List<PurchaseOrder> getPurchase(){
		return purchase;
	}
	
	public void setPurchase(ArrayList<PurchaseOrder> purchase) {
		this.purchase = purchase;
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
}
