package com.store.storeapp.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long purchaseOrderId;
	
	@NonNull
	@OneToOne
	private StatusOrder orderStatus;
	
	@OneToOne
	private ConfirmOrder confirmOrder;
	
	@ManyToOne
	private Customer customerId;
	
	@NonNull
	private Date orderDate;
	
	@NonNull
	private String formPayment;
	
	//construct
	public PurchaseOrder() {}

	//get and set
	public long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public StatusOrder getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(StatusOrder orderStatus) {
		this.orderStatus = orderStatus;
	}

	public ConfirmOrder getConfirmOrder() {
		return confirmOrder;
	}

	public void setConfirmOrder(ConfirmOrder confirmOrder) {
		this.confirmOrder = confirmOrder;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
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
	
	
	
}
