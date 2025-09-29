package com.wolfman.mall.product.controller;

import com.wolfman.mall.product.entity.Product;
import com.wolfman.mall.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable String productId) {
        System.out.println("productId: " + productId);
        Product product = productService.getProductById(productId);
        System.out.println("product: " + product);
        return productService.getProductById(productId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategoryId(@PathVariable String categoryId) {
        System.out.println("categoryId: " + categoryId);
        return productService.getProductsByCategoryId(categoryId);
    }

    @GetMapping("/brand-category")
    public List<Product> getProductsByBrandAndCategoryId(@RequestParam String brand, @RequestParam String categoryId) {
        return productService.getProductsByBrandAndCategoryId(brand, categoryId);
    }
}