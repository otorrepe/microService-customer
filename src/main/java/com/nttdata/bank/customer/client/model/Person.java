package com.nttdata.bank.customer.client.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	@Id
	private String _id;
	
	private String name;
	
	private String surnames;
	
	private int mobile;
	
	private String email;
	
	private String document;

	private Byte type;
	
	private String description;
	
	@JsonIgnore
	private String customerId;
	
}
