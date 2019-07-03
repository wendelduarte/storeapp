package com.store.storeapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ProductOrder {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long productOrderId;
	
		@ManyToOne
		@JoinColumn(name="PURCHASE_ORDER_FK")
		private PurchaseOrder purchaseOrder;
		
		@ManyToOne
		@JoinColumn(name="PRODUCT_FK")
		private Product product;
		
		private int quantityProduct;
		
		//construct
		public ProductOrder(){}
		
		public ProductOrder(Long productOrderId, PurchaseOrder purchaseOrder, Product product, int quantityProduct) {
			super();
			this.productOrderId = productOrderId;
			this.purchaseOrder = purchaseOrder;
			this.product = product;
			this.quantityProduct = quantityProduct;
		}

		public Long getProductOrderId() {
			return productOrderId;
		}

		public void setProductOrderId(Long productOrderId) {
			this.productOrderId = productOrderId;
		}
		
		@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
		public PurchaseOrder getPurchaseOrder() {
			return purchaseOrder;
		}

		public void setPurhcaseOrder(PurchaseOrder purhcaseOrder) {
			this.purchaseOrder = purhcaseOrder;
		}

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

		public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
			this.purchaseOrder = purchaseOrder;
		}
		
}
