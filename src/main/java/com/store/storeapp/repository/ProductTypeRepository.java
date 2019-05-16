package com.store.storeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long>{

}
