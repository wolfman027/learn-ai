package com.wolfman.alibaba_ai_cloud_demo.calling.product;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class ProductServiceImpl implements ProductService {

    private RestTemplate restTemplate = new RestTemplate();

    @Tool(description = "根据商品ID获取商品的详细信息")
    @Override
    public String getProductById(String productId) {
        System.out.println("调用了getProductById方法");
        String url = "http://localhost:8082/api/products/{productId}";
        try {
            // 先获取原始 JSON 字符串
            ResponseEntity<String> jsonResponse = restTemplate.getForEntity(url, String.class, productId);
            System.out.println("=== API 原始返回内容 ===");
            System.out.println("状态码: " + jsonResponse.getStatusCode());
            System.out.println("JSON内容: " + jsonResponse.getBody());
            System.out.println("========================");
            return jsonResponse.getBody();
        } catch (Exception e) {
            System.err.println("调用API时发生错误: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}