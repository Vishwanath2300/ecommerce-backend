package com.catalogue.ecommerce.Service;


import com.catalogue.ecommerce.Entity.Products;
import com.catalogue.ecommerce.Repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class productService {


    @Autowired
    private productRepository productRepo;

    public List<Products> allproducts() {
        return productRepo.findAll();
    }

    public Products addProducts(Products product) {
        return productRepo.save(product);
    }

    public String deleteProducts(Long id) {
        productRepo.deleteById(id);

        if (productRepo.existsById(id)) {
            return "Unsuccessful";
        } else {
            return "Successful";
        }
    }


    public Products editproduct(Long id,Products updatedProduct) {

        Products existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        existingProduct.setProduct_name(updatedProduct.getProduct_name());
        existingProduct.setProduct_description(updatedProduct.getProduct_description());
        existingProduct.setProduct_price(updatedProduct.getProduct_price());
        existingProduct.setProduct_category(updatedProduct.getProduct_category());
        existingProduct.setProduct_image(updatedProduct.getProduct_image());

        return productRepo.save(existingProduct);

    }
}
