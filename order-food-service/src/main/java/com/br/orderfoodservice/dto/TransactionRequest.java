package com.br.orderfoodservice.dto;

import com.br.orderfoodservice.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private Order order;
    private PaymentRequest paymentRequest;
}
