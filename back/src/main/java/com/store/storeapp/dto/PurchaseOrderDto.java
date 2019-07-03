package com.store.storeapp.dto;

import java.util.Set;

public class PurchaseOrderDto {

	private Long customerId;
	private Long statusOrderId;
	private Set<ProductOrderDto> productOrder;
	private String date;
	private float total;
	

	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getStatusOrderId() {
		return statusOrderId;
	}
	public void setStatusOrderId(Long statusOrderId) {
		this.statusOrderId = statusOrderId;
	}
	public Set<ProductOrderDto> getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(Set<ProductOrderDto> productOrder) {
		this.productOrder = productOrder;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
