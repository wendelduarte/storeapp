package com.store.storeapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class ProductOrder {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer productOrderId;
	
		@ManyToOne
		private PurchaseOrder purchaseOrder;
		
		@NonNull
		@ManyToOne
		private Product productId;
		
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

		public PurchaseOrder getPurchaseOrder() {
			return purchaseOrder;
		}

		public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
			this.purchaseOrder = purchaseOrder;
		}

		public Product getProductId() {
			return productId;
		}

		public void setProductId(Product productId) {
			this.productId = productId;
		}

		public int getQuantityProduct() {
			return quantityProduct;
		}

		public void setQuantityProduct(int quantityProduct) {
			this.quantityProduct = quantityProduct;
		}
}
