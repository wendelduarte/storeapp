package com.store.storeapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
		
		@NotNull
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
