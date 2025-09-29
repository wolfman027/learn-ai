package com.wolfman.mall.product.service.impl;

import com.wolfman.mall.product.entity.Product;
import com.wolfman.mall.product.mapper.ProductMapper;
import com.wolfman.mall.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getProductById(String productId) {
        return productMapper.selectByProductId(productId);
    }

    @Override
    public List<Product> getProductsByCategoryId(String categoryId) {
        return productMapper.selectByCategoryId(categoryId);
    }

    @Override
    public List<Product> getProductsByBrandAndCategoryId(String brand, String categoryId) {
        return productMapper.selectByBrandAndCategoryId(brand, categoryId);
    }
}