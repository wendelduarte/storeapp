package com.store.storeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.Product;
import com.store.storeapp.models.ProductType;
import com.store.storeapp.models.Provider;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("SELECT c from Product c order by price")
	List<Product> getProductOrderByPrice ();

	@Query("SELECT c from Product c order by price desc")
	List<Product> getProductOrderByPriceDesc ();
	
    @Query("SELECT p FROM Product p WHERE " + "LOWER(p.name) LIKE LOWER(CONCAT('%',:name, '%')) order by name")
	List<Product> getByName (@Param("name") String name);
    
    @Query("SELECT p FROM Product p WHERE (p.productType = :productType)")
    List<Product> typeProduct(@Param("productType") ProductType productType);
    
    @Query("SELECT p FROM Product p WHERE (p.productType = :productType) and LOWER(p.name) LIKE LOWER(CONCAT('%',:name, '%')) order by name")
    List<Product> findByTypeAndName(@Param("productType") ProductType productType, @Param("name") String name);
    
	@Query("SELECT p from Product p where p.provider = :provider")
	List<Product> getProductByProvider(@Param("provider") Provider provider);
}
