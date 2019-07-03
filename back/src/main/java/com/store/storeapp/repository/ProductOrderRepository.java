package com.store.storeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.ProductOrder;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long>{
	

}
