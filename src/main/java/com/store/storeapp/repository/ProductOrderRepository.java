package com.store.storeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.ProductOrder;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long>{

	@Query("SELECT SUM((o.quantityProduct * p.price)) from ProductOrder o, Product p where o.productId = p.productId")
	float totalOfProduct();
}
