package com.store.storeapp.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long purchaseOrderId;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name="STATUS_ORDER_FK")
	private StatusOrder orderStatus;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_FK")
	private Customer customer;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "purchaseOrder")
	private Set<ProductOrder> productOrder;	
	
	@NonNull
	private Date orderDate;
	
	@NonNull
	private String formPayment;
	
	private float total;

	//construct
	public PurchaseOrder() {}

	//get and set
	public long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	@JsonIgnore
	public StatusOrder getOrderStatus() {
		return orderStatus;
	}

	public Set<ProductOrder> getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(Set<ProductOrder> productOrder) {
		this.productOrder = productOrder;
	}

	public void setOrderStatus(StatusOrder orderStatus) {
		this.orderStatus = orderStatus;
	}

	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customerId) {
		this.customer = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getFormPayment() {
		return formPayment;
	}

	public void setFormPayment(String formPayment) {
		this.formPayment = formPayment;
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
}
