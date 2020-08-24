package com.br.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "transactionStatus") //namespace = "http://www.w3.org/2001/XMLSchema-instance"
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionStatus {

    private int status;
    private String reference;
}
