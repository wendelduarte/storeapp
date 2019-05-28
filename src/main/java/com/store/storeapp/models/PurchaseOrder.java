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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long purchaseOrderId;
	
	@ManyToOne
	@JoinColumn(name="STATUS_ORDER_FK")
	private StatusOrder orderStatus;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="CUSTOMER_FK")
	private Customer customer;

	@NotNull
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "purchaseOrder")
	private Set<ProductOrder> productOrder;	
	
	@Temporal(TemporalType.DATE)     
	private Date orderDate;
	
	private String formPayment;
	
	
	private Float total;

	//construct
	public PurchaseOrder() {}
	
	public PurchaseOrder(long purchaseOrderId,float total) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.total = total;
	}



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
