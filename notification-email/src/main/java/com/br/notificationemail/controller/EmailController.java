package com.br.notificationemail.controller;

import com.br.notificationemail.dto.EmailRequest;
import com.br.notificationemail.model.Email;
import com.br.notificationemail.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
@AllArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){
        emailService.sendMail(emailRequest);
        return new ResponseEntity<>("email sent with successful",HttpStatus.OK);
    }

}
