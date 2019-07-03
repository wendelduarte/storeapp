package com.store.storeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.Customer;
import com.store.storeapp.models.DeliveryAddressCustomer;

@Repository
public interface DeliveryAddressCustomerRepository extends JpaRepository <DeliveryAddressCustomer, Long>{
	
	@Query("SELECT a from DeliveryAddressCustomer a where a.customer = :customer")
	List<DeliveryAddressCustomer> getDeliveryAddresByCustomer(@Param("customer") Customer customer);
}
