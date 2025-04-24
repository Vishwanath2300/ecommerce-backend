package com.catalogue.ecommerce.Repository;


import com.catalogue.ecommerce.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<Products,Long> {


    boolean findAllById(Long id);
}
