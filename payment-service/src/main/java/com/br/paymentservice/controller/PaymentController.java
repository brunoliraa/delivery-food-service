package com.br.paymentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

//    private final PaymentService paymentService;

//    @PostMapping
//    public ResponseEntity<Payment> savePayment(@RequestBody PaymentRequest paymentRequest){
//        return paymentService.doPayment(paymentRequest);
//    }

//    @PostMapping("/pagseguro/notification")
//    public ResponseEntity<Void> getNotificatonCode(@RequestBody AuthorizationCode authorizationCode){
//       return paymentService.notification(authorizationCode);
//    }
}
