package com.br.orderfoodservice.controller;

import com.br.orderfoodservice.model.Order;
import com.br.orderfoodservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderControlelr {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order){
        return orderService.doOrder(order);
    }


}
