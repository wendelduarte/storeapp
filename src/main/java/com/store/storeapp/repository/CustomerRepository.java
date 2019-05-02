package com.store.storeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
