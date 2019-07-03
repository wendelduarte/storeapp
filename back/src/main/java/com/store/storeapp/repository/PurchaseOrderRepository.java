package com.store.storeapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.Customer;
import com.store.storeapp.models.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long>{
	
	@Query("SELECT p from PurchaseOrder p where customer = :customer")
	List<PurchaseOrder> getAllPurchaseOrderByCustomer(@Param("customer") Customer customer);

	/*
	@Transactional
	@Modifying
	@Query("update PurchaseOrder po set total = (select sum(o.quantityProduct * p.price) "
			+ "from ProductOrder o, Product p "
			+ "where (o.product = p.productId) and (po.purchaseOrderId = o.purchaseOrder) "
			+ "group by o.purchaseOrder) "
			+ "where (po.customer = :customer)")
	void totalPrice(@Param("customer") Customer customer);
	*/
	
	@Query("SELECT p from PurchaseOrder p where (customer = :customer) and (orderStatus = 4)")
	PurchaseOrder getPurchaseOrderByStatus(@Param("customer") Customer customer);
	
}
