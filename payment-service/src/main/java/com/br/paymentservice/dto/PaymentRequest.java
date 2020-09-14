package com.br.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRequest  {

    private Long id;
    private String paymentStatus;
    private String transactionId;
    private Long orderId;
    private BigDecimal amout;

    public PaymentRequest(@JsonProperty("id") Long id, @JsonProperty("paymentStatus") String paymentStatus
            , @JsonProperty("transactionId") String transactionId, @JsonProperty("orderId") Long orderId
            , @JsonProperty("amout") BigDecimal amout) {

        this.id= id;
        this.paymentStatus=paymentStatus;
        this.transactionId=transactionId;
        this.orderId=orderId;
        this.amout=amout;
    }

    public PaymentRequest(){}
}