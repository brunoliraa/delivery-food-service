package com.br.paymentservice.service;

import com.br.paymentservice.dto.TransactionStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    private final RestTemplate restTemplate;
    private final ConvertXmlToPojo convertXmlToPojo;

    public TransactionStatus TransactionStatus(String code){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ws.sandbox.pagseguro.uol.com.br/v3/transactions/notifications/"+code+"?"+"email=email"+"&token=token";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//        TransactionSearchResult transactionSearchResult = restTemplate.getForObject(url,TransactionSearchResult.class);

        TransactionStatus transaction = convertXmlToPojo.convertTransaction(response.getBody());
        return transaction;

    }

}
