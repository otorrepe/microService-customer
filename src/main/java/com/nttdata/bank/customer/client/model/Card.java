package com.nttdata.bank.customer.client.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Card {
	
	@Id
	private String _id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String customerId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String productId;
	
	private String mainAccount;
	
	private List<String> associatedAccounts;
	
	private Product product;
	
	private String createAt;
	
	/*Tarjeta credito*/
	private Double amount;
	
	private Double amountAvailable;

}
