package com.br.paymentservice.service;

import com.br.paymentservice.dto.PaymentRequest;
import com.br.paymentservice.model.Payment;
import com.br.paymentservice.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public ResponseEntity<Payment> doPayment(PaymentRequest paymentRequest)  {
        Payment payment = new Payment();
//        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        log.info("Payment-Service Request : {}");;

        return ResponseEntity.ok(paymentRepository.save(payment));
    }


//    public String paymentProcessing(){
//        //api should be 3rd party payment gateway (paypal,paytm...)
//        return new Random().nextBoolean()?"success":"false";
//    }
//
//
//    public Payment findPaymentHistoryByOrderId(int orderId) {
//        Payment payment=repository.findByOrderId(orderId);
//        logger.info("paymentService findPaymentHistoryByOrderId : {}",new ObjectMapper().writeValueAsString(payment));
//        return payment ;
//    }
}
