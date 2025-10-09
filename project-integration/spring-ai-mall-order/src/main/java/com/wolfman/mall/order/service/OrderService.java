package com.wolfman.mall.order.service;

import com.wolfman.mall.order.entity.Order;
import com.wolfman.mall.order.entity.OrderDetail;
import com.wolfman.mall.order.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getOrders() {
        List<Order> orders = orderMapper.selectAllOrders();
        for (Order order : orders) {
            List<OrderDetail> details = orderMapper.selectOrderDetailsByOrderId(order.getOrderId());
            order.setOrderDetails(details);
        }
        return orders;
    }

    public Order getOrderById(String orderId) {
        Order order = orderMapper.selectOrderById(orderId);
        if (order != null) {
            List<OrderDetail> details = orderMapper.selectOrderDetailsByOrderId(orderId);
            order.setOrderDetails(details);
        }
        return order;
    }

    public List<Order> getOrdersByUserId(String userId) {
        List<Order> orders = orderMapper.selectOrdersByUserId(userId);
        for (Order order : orders) {
            List<OrderDetail> details = orderMapper.selectOrderDetailsByOrderId(order.getOrderId());
            order.setOrderDetails(details);
        }
        return orders;
    }

    public boolean cancelOrder(String orderId) {
        return orderMapper.cancelOrder(orderId) > 0;
    }
}