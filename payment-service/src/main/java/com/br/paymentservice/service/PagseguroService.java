package com.br.paymentservice.service;

import com.br.paymentservice.dto.TransactionStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class PagseguroService {

    private final ClientService clientService;


    public TransactionStatus getStatusTransacao(String code) {

        return clientService.TransactionStatus(code);

    }

}
