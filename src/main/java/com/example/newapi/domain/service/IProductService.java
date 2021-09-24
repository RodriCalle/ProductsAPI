package com.example.newapi.domain.service;

import com.example.newapi.domain.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {
    Product createProduct(Product product);
    Product getProduct(Long id);
    Product updateProduct(Long id, Product productDetails);
    ResponseEntity<?> deleteProduct(Long id);

    List<Product> getAllProducts();
    Product getProductByName(String name);
}
