package com.br.notificationemail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {

    @NotBlank(message = "subject can't be null")
    @NotNull(message = "subject can't be blank")
    private String subject;
    @NotBlank(message = "recipient can't be null")
    @NotNull(message = "recipient can't be blank")
    private String recipient;
    @NotBlank(message = "body can't be null")
    @NotNull(message = "body can't be blank")
    private String body;
}
