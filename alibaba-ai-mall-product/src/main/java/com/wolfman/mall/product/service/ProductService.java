package com.wolfman.mall.product.service;


import com.wolfman.mall.product.entity.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(String productId);
    List<Product> getProductsByCategoryId(String categoryId);
    List<Product> getProductsByBrandAndCategoryId(String brand, String categoryId);
}