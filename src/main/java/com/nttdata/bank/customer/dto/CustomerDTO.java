package com.nttdata.bank.customer.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.nttdata.bank.customer.client.model.Account;
import com.nttdata.bank.customer.client.model.Card;
import com.nttdata.bank.customer.client.model.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CustomerDTO {
	
	private String _id;
	
	private Byte type;
	
	private String description;
	
	private String name;
	
	private String document;
	
	private String createAt;
	
	private List<Person> persons = new ArrayList<Person>();
	
	private List<Account> account = new ArrayList<Account>();
	
	private List<Card> cards = new ArrayList<Card>();

}
