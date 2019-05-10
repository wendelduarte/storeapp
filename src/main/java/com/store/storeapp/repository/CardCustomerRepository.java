package com.store.storeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.CardCustomer;
import com.store.storeapp.models.Customer;

@Repository
public interface CardCustomerRepository extends JpaRepository<CardCustomer, Long>{

	@Query("SELECT c from CardCustomer c where c.customerId = :customerId")
	List<CardCustomer> getCardCustomerByCustomerId(@Param("customerId") Customer customerId);
}
