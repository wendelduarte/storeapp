package com.store.storeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.store.storeapp.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("SELECT c from Product c order by price")
	List<Product> getProductOrderByPrice ();

	@Query("SELECT c from Product c order by price desc")
	List<Product> getProductOrderByPriceDesc ();
	
    @Query("SELECT p FROM Product p WHERE " + "LOWER(p.name) LIKE LOWER(CONCAT('%',:name, '%')) order by name")
	List<Product> getByName (@Param("name") String name);
}
