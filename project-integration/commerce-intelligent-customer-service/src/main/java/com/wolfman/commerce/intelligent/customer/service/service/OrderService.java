package com.wolfman.commerce.intelligent.customer.service.service;


import com.wolfman.commerce.intelligent.customer.service.data.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService{

    @Autowired
    private RestTemplate restTemplate;


    public List<Order> getOrders() {
        // 尝试远程调用
        String url = "http://localhost:9001/api/orders/list";
        return restTemplate.getForObject(url, List.class);
    }

    public List<Order> getOrdersByUserId(String userId) {

        // 尝试远程调用
        String url = "http://localhost:9001/api/orders/user/" + userId;
        return restTemplate.getForObject(url, List.class);

    }

    public Order getOrderById(String orderId) {
        String url = "http://localhost:9001/api/orders/{orderId}";
        return restTemplate.getForObject(url, Order.class, orderId);
    }

    public boolean cancelOrder(String orderId) {
        String url = "http://localhost:9001/api/orders/cancel/{orderId}";
        return restTemplate.postForObject(url, null, Boolean.class, orderId);
    }


}