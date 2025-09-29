package com.wolfman.mall.product.entity;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Product {
    private String productId;
    private String productName;
    private String description;
    private String specifications;
    private String usageInfo;
    private String brand;
    private BigDecimal price;
    private Integer stockQuantity;
    private String categoryId;
    private Integer status;

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", specifications='" + specifications + '\'' +
                ", usageInfo='" + usageInfo + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", categoryId='" + categoryId + '\'' +
                ", status=" + status +
                '}';
    }
}
