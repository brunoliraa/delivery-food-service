package com.br.orderfoodservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private Long id;
    private String paymentStatus;
    private String transactionId;
    private Long orderId;
}
