package com.br.orderfoodservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderFoodServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderFoodServiceApplication.class, args);
	}

}
