package com.wolfman.commerce.intelligent.customer.service.service;


import com.wolfman.commerce.intelligent.customer.service.data.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.core.NestedExceptionUtils;

import java.util.List;

public class OrderTools {

    private static final Logger logger = LoggerFactory.getLogger(OrderTools.class);

    private final OrderService orderService;

    public OrderTools(OrderService orderService) {
        this.orderService = orderService;
    }


    @Tool(description = "根据用户ID获取订单列表")
    public List<Order> getOrderByUserId(String userId) {
        try {
            logger.info("根据用户ID获取订单列表 用户ID: {}", userId);
            return orderService.getOrdersByUserId(userId);
        } catch (Exception e) {
            logger.warn("用户的订单列表: {}", NestedExceptionUtils.getMostSpecificCause(e).getMessage());
            return null;
        }
    }


    @Tool(description = "获取订单详细信息")
    public Order getOrderDetails(String orderId) {
        try {
            logger.info("获取订单详细信息 用户ID: {}", orderId);
            return orderService.getOrderById(orderId);
        } catch (Exception e) {
            logger.warn("Order详情: {}", NestedExceptionUtils.getMostSpecificCause(e).getMessage());
            return null;
        }
    }

    @Tool(description = "取消订单")
    public Boolean cancelOrder(String orderId) {
        try {
            logger.info("取消订单 用户ID: {}", orderId);
            validateCancelOrder(orderId, orderService.getOrderById(orderId).getOrderStatus());
            return orderService.cancelOrder(orderId);
        } catch (Exception e) {
            logger.warn("取消订单: {}", NestedExceptionUtils.getMostSpecificCause(e).getMessage());
            return null;
        }
    }

    /**
     * 取消订单逻辑校验
     *
     * @throws IllegalStateException 当订单状态≥2时抛出异常
     */
    public void validateCancelOrder(String orderId, Integer orderStatus) {
        // 状态验证
        if (orderStatus >= 2) {
            throw new IllegalStateException("订单[" + orderId + "]已发货/完成，不可取消");
        }
        //  其他逻辑验证
    }
}