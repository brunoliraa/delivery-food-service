package com.br.orderfoodservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Slf4j
public class TestController {

    @Value("${teste.texto}")
    private String urlTest;


    @GetMapping("/teste")
    public String getUrlTest(){
//        System.out.println(urlTest);
        log.info("info {}", urlTest);
        return urlTest;
    }
}
