package com.store.storeapp.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long purchaseOrderId;
	
	@ManyToOne
	@JoinColumn(name="STATUS_ORDER_FK")
	private StatusOrder orderStatus;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_FK")
	private Customer customer;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "purchaseOrder")
	private Set<ProductOrder> productOrder;	
	
     
	private String orderDate;
	
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

	//@JsonIgnore
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

	//@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
}
