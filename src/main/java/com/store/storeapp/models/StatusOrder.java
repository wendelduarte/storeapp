package com.store.storeapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

@Entity
public class StatusOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long statusId;
	
	@OneToOne
	private PurchaseOrder order;
	
	@NonNull
	private String orderStatus;
	
	public StatusOrder() {
		this.orderStatus="Aguardando pagamento";
	}


	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public PurchaseOrder getOrder() {
		return order;
	}

	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
