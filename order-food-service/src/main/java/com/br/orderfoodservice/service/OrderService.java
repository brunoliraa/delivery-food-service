package com.br.orderfoodservice.service;

import com.br.orderfoodservice.model.Order;
import com.br.orderfoodservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public ResponseEntity<Order> doOrder(Order order){
        return ResponseEntity.ok(orderRepository.save(order));

        //chamada para Api de pagamento passando o Id do pedido, para fazer o mapeamento entre order e payment
    }
}
