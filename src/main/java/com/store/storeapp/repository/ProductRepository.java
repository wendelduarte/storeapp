package com.store.storeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
