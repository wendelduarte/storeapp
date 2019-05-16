package com.store.storeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.ProviderProduct;

@Repository
public interface ProviderProductRepository extends JpaRepository<ProviderProduct, Long>{


}
