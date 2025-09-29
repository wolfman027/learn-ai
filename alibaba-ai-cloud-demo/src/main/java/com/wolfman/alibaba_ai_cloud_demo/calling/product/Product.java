package com.wolfman.alibaba_ai_cloud_demo.calling.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
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