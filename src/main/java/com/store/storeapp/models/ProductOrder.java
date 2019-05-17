package com.store.storeapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProductOrder {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer productOrderId;
	
		@ManyToOne
		@JoinColumn(name="PURCHASE_ORDER_FK")
		private PurchaseOrder purchaseOrder;
		
		@ManyToOne
		@JoinColumn(name="PRODUCT_FK")
		private Product product;
		
		@NonNull
		private int quantityProduct;
		
		//construct
		public ProductOrder(){}

		public Integer getProductOrderId() {
			return productOrderId;
		}

		public void setProductOrderId(Integer productOrderId) {
			this.productOrderId = productOrderId;
		}
		
		@JsonIgnore
		public PurchaseOrder getPurchaseOrder() {
			return purchaseOrder;
		}

		public void setPurhcaseOrder(PurchaseOrder purhcaseOrder) {
			this.purchaseOrder = purhcaseOrder;
		}
		@JsonIgnore
		public Product getProduct() {
			return product;
		}

		public void setProduct(Product prodcut) {
			this.product = prodcut;
		}

		public int getQuantityProduct() {
			return quantityProduct;
		}

		public void setQuantityProduct(int quantityProduct) {
			this.quantityProduct = quantityProduct;
		}
}
