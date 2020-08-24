package com.br.paymentservice.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "transactionSearchResult")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionSearchResult {

    private String date;
    private int resultsInThisPage;
    private int currentPage;
    private int totalPages;
}
