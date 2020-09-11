package com.br.paymentservice.service;

import com.br.paymentservice.dto.AuthorizationCode;
import com.br.paymentservice.dto.PaymentRequest;
import com.br.paymentservice.model.Payment;
import com.br.paymentservice.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PagseguroService pagseguroService;

    public ResponseEntity<Payment> doPayment(PaymentRequest paymentRequest)  {
        Payment payment = new Payment();
        payment.setTransactionId(UUID.randomUUID().toString());
        log.info("Payment Request : {}");;

        return ResponseEntity.ok(paymentRepository.save(payment));
    }

    public ResponseEntity<Void> notification(AuthorizationCode authorizationCode){
        pagseguroService.getStatusTransacao(authorizationCode.getNotificationCode());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
