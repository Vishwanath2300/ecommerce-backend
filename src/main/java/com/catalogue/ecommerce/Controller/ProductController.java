package com.catalogue.ecommerce.Controller;


import com.catalogue.ecommerce.Entity.Products;
import com.catalogue.ecommerce.Repository.productRepository;
import com.catalogue.ecommerce.Service.productService;
import com.catalogue.ecommerce.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;

@RestController
public class ProductController {

    @Autowired
    private userService userSer;

    @Autowired
    private productService productServ;

    @GetMapping("/Products")
    public ResponseEntity<List<Products>> getProdcuts(){
        return ResponseEntity.ok(productServ.allproducts());
    }
    @PostMapping("/Create/Product")
    public ResponseEntity<Products> addProduct(@RequestBody Products product){
    return ResponseEntity.ok(productServ.addProducts(product));
    }

    @DeleteMapping("/delete/Product/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        String message = productServ.deleteProducts(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/edit/Product/{id}")
    public ResponseEntity<Products> editProduct(@PathVariable Long id, @RequestBody Products product){
        return ResponseEntity.ok(productServ.editproduct(id,product));
    }
}
