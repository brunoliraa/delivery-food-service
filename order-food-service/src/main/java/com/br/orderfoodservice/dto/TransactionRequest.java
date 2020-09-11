package com.br.orderfoodservice.dto;

import com.br.orderfoodservice.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest implements Serializable {

    private Order order;
    private PaymentRequest paymentRequest;
}
