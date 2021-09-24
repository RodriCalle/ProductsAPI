package com.example.newapi.controller;

import com.example.newapi.domain.model.Product;
import com.example.newapi.domain.service.IProductService;
import com.example.newapi.resource.ProductResource;
import com.example.newapi.resource.SaveProductResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IProductService productService;

    private Product convertToEntity(SaveProductResource resource){
        return modelMapper.map(resource, Product.class);
    }

    private ProductResource convertToResource(Product entity){
        return modelMapper.map(entity, ProductResource.class);
    }

    @PostMapping("/products")
    public ProductResource  createProduct(@RequestBody @Valid SaveProductResource resource){
        Product p = productService.createProduct(convertToEntity(resource));
        return convertToResource(p);
    }

    @GetMapping("/products")
    public List<ProductResource> getAllProducts(){
        return productService.getAllProducts()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
    }

    @PutMapping("/products/{id}")
    public ProductResource updateProduct(@PathVariable Long id, @Valid @RequestBody SaveProductResource resource){
        Product product = convertToEntity(resource);
        return convertToResource(productService.updateProduct(id, product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }


}
