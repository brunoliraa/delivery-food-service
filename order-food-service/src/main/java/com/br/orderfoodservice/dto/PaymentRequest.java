package com.br.orderfoodservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest implements Serializable {

    private Long id;
    private String paymentStatus;
    private String transactionId;
    private Long orderId;
    private BigDecimal amout;
}
