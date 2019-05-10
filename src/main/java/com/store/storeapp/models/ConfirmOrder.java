package com.store.storeapp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

@Entity
public class ConfirmOrder {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer confirmOrderId;
	
		@OneToOne
		private PurchaseOrder purchaseOrder;
		
		@NonNull
		@OneToMany
		private List<Product> productsOrder;
		
		@NonNull
		private int quantityProduct;
		
		//construct
		public ConfirmOrder(){}

		//Getter and setters
		public PurchaseOrder getPurchaseOrder() {
			return purchaseOrder;
		}

		public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
			this.purchaseOrder = purchaseOrder;
		}

		public List<Product> getProductsOrder() {
			return productsOrder;
		}

		public void setProductsOrder(List<Product> productsOrder) {
			this.productsOrder = productsOrder;
		}

		public int getQuantityProduct() {
			return quantityProduct;
		}

		public void setQuantityProduct(int quantityProduct) {
			this.quantityProduct = quantityProduct;
		}		
}
