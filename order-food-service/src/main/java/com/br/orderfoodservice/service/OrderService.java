package com.br.orderfoodservice.service;

import com.br.orderfoodservice.dto.PaymentRequest;
import com.br.orderfoodservice.dto.TransactionRequest;
import com.br.orderfoodservice.dto.TransactionResponse;
import com.br.orderfoodservice.model.Order;
import com.br.orderfoodservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
@AllArgsConstructor
//@RefreshScope
public class OrderService {

    private final OrderRepository orderRepository;
//    @Lazy
//    private final RestTemplate restTemplate;

    private final RabbitTemplate rabbitTemplate;

//    @Value("${microservices.payment-service.endpoints.endpoint.uri}")
//    private String ENDPOINT_URL;


    @Lazy
    public ResponseEntity<TransactionResponse> doOrder(TransactionRequest transactionRequest){
        Order order = transactionRequest.getOrder();
        PaymentRequest paymentRequest = transactionRequest.getPaymentRequest();
        orderRepository.save(order);
        paymentRequest.setOrderId(order.getId());

//        PaymentRequest paymentResponse =restTemplate.postForObject("url",paymentRequest, PaymentRequest.class);

        rabbitTemplate.convertAndSend("myExchange", "test.order", "testando rabbit");
        //escuta a resposta em uma outra fila para pegar o resultado

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setOrder(order);
//        transactionResponse.setTransactionId(paymentResponse.getTransactionId());
        return ResponseEntity.ok(transactionResponse);
         }


}
