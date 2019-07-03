package com.store.storeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.StatusOrder;

@Repository
public interface StatusOrderRepository extends JpaRepository<StatusOrder, Long>{
	
}
