package com.store.storeapp.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class StatusOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long statusId;
	

	@NotNull
	private String orderStatus;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "orderStatus")
	private Set<PurchaseOrder> purchaseOrder;

	
	public StatusOrder() {
		this.orderStatus="Aguardando pagamento";
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
	public Set<PurchaseOrder> getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(Set<PurchaseOrder> purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}	
}
