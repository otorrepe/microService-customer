package com.nttdata.bank.customer.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.bank.customer.client.model.Card;

import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;

@ReactiveFeignClient(name = "service-card", url = "localhost:9935")
public interface CardRest {
	
	@GetMapping
	public Flux<Card> findByCustomerId(@RequestParam String customerId);

}
