package com.br.paymentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Value("${teste.texto}")
    private String urlTest;


    @GetMapping("/teste")
    public String getUrlTest(){
//        System.out.println(urlTest);
        return urlTest;
    }
}
