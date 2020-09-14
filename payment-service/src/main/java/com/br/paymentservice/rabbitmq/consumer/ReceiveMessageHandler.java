package com.br.paymentservice.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReceiveMessageHandler {

    public void handleMessage(String message){
        log.info("HandleMessage!!!");
        log.info(message);
    }

}
