package com.wolfman.commerce.intelligent.customer.service.controller;


import com.wolfman.commerce.intelligent.customer.service.data.Order;
import com.wolfman.commerce.intelligent.customer.service.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/api/orders")
    @ResponseBody
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
}