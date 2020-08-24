package com.br.notificationemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NotificationEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationEmailApplication.class, args);
	}

}
