package com.br.orderfoodservice.controller;

import com.br.orderfoodservice.dto.PaymentRequest;
import com.br.orderfoodservice.dto.TransactionRequest;
import com.br.orderfoodservice.dto.TransactionResponse;
import com.br.orderfoodservice.model.Order;
import com.br.orderfoodservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<TransactionResponse> save(@RequestBody TransactionRequest transactionRequest){
        return orderService.doOrder(transactionRequest);
    }

    @GetMapping
    public String helloworld(){
        return "hello world spring cloud";
    }



}
