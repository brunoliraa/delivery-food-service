package com.br.paymentservice.controller;

import com.br.paymentservice.dto.AuthorizationCode;
import com.br.paymentservice.dto.PaymentRequest;
import com.br.paymentservice.model.Payment;
import com.br.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> savePayment(@RequestBody PaymentRequest paymentRequest){
        return paymentService.doPayment(paymentRequest);
    }

    @PostMapping("/pagseguro/notification")
    public ResponseEntity<Void> getNotificatonCode(@RequestBody AuthorizationCode authorizationCode){
       return paymentService.notification(authorizationCode);
    }
}
