package com.nttdata.bank.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.nttdata.bank.customer.client.AccountRest;
import com.nttdata.bank.customer.client.CardRest;
import com.nttdata.bank.customer.client.PersonRest;
import com.nttdata.bank.customer.dto.CustomerDTO;
import com.nttdata.bank.customer.model.Customer;
import com.nttdata.bank.customer.repository.CustomerRepository;
import com.nttdata.bank.customer.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PersonRest personRest;
	
	@Autowired
	private CardRest cardRest;
	
	@Autowired
	private AccountRest accountRest;
	
	@Autowired
	private JsonMapper jsonMapper;

	@Override
	public Mono<Customer> save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Mono<Customer> showCustomerInformationById(String id) {
		return customerRepository.findById(id);
	}

	@Override
	public Flux<CustomerDTO> findAll() {
		return customerRepository.findAll().map(c ->convertirACustomerDTO(c))
				.flatMap(customer -> 
					Mono.just(customer)
					.zipWith(personRest.findByCustomerId(customer.get_id())
						 .collectList(),
						 (c, p) -> {
							 c.setPersons(p);
							 return c;
						 })
					.zipWith(accountRest.findByCustomerId(customer.get_id())
							 .collectList(),
							 (c, a) -> {
								 c.setAccount(a);
								 return c;
						})
					.zipWith(cardRest.findByCustomerId(customer.get_id())
							 .collectList(),
							 (c, ca) -> {
								 c.setCards(ca);
								 return c;
							 }));
	}

	@Override
	public Mono<CustomerDTO> findById(String id) {
		return customerRepository.findById(id).map(c ->convertirACustomerDTO(c))
				.flatMap(customer -> 
					Mono.just(customer)
					.zipWith(personRest.findByCustomerId(customer.get_id())
						 .collectList(),
						 (c, p) -> {
							 c.setPersons(p);
							 return c;
						 })
					.zipWith(accountRest.findByCustomerId(customer.get_id())
							 .collectList(),
							 (c, a) -> {
								 c.setAccount(a);
								 return c;
						})
					.zipWith(cardRest.findByCustomerId(customer.get_id())
							 .collectList(),
							 (c, ca) -> {
								 c.setCards(ca);
								 return c;
							 }));
	}
	
	/*Casteo de objetos usando JsonMapper*/
	private CustomerDTO convertirACustomerDTO(Customer customer) {
		return jsonMapper.convertValue(customer, CustomerDTO.class);
	}
	
}
