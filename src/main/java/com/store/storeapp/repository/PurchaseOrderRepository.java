package com.store.storeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.Customer;
import com.store.storeapp.models.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long>{
	
	@Query("SELECT p from PurchaseOrder p where customerId = :customerId")
	List<PurchaseOrder> getAllPurchaseOrderByCustomerId(@Param("customerId") Customer customerId);
}
