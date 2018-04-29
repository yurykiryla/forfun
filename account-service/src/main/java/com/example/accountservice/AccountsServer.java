package com.example.accountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
public class AccountsServer {
	
	@Autowired
	AccountRepository accountRepository;
	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "accounts-server");
		
		SpringApplication.run(AccountsServer.class, args);
	}
}
