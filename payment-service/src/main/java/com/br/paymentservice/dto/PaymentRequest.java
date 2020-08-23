package com.br.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private Long id;
    private String paymentStatus;
    private String transactionId;
    private Long orderId;
    private BigDecimal total;
}
