package com.br.paymentservice.service;

import com.br.paymentservice.dto.PaymentRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class TestReceive  {

    @RabbitListener(queues = "myQueue")
    public void receive(PaymentRequest message){

        System.out.println(message);


  }
}
