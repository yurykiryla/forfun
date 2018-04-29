package com.example.accountservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1828147973483181379L;

	public AccountNotFoundException(String accountNumber) {
		super("No such account: " + accountNumber);
	}

}
