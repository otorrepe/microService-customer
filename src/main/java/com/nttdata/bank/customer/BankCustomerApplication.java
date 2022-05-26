package com.nttdata.bank.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableReactiveFeignClients
public class BankCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankCustomerApplication.class, args);
	}

}
