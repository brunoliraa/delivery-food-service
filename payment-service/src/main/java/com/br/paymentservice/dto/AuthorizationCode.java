package com.br.paymentservice.dto;

import lombok.Data;

@Data
public class AuthorizationCode {

    private String notificationCode;
    private String notificationType;
}
